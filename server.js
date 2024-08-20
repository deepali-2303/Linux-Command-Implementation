const express = require('express');
const http = require('http');
const fs = require('fs');
const path = require('path');
const { Server } = require('socket.io');

const app = express();
const server = http.createServer(app);
const io = new Server(server);
const port = 3000;
const logFilePath = path.join(__dirname, 'logfile.log');

// Array to hold connected clients
let clients = [];

const monitorLogFile = () => {
    fs.watchFile(logFilePath, (curr, prev) => {
        if (curr.mtime > prev.mtime) {
            fs.readFile(logFilePath, 'utf8', (err, data) => {
                if (err) throw err;
                const newLines = data.split('\n').slice(-1).join('\n');
                broadcastUpdate(newLines);
            });
        }
    });
};

const broadcastUpdate = (data) => {
    clients.forEach(client => {
        client.emit('logUpdate', data);
    });
};

monitorLogFile();

app.use(express.static('public'));

io.on('connection', (socket) => {
    console.log('New client connected');
    clients.push(socket);

    // Send the last 10 lines of the log file to the new client
    fs.readFile(logFilePath, 'utf8', (err, data) => {
        if (err) {
            socket.emit('error', 'Error reading log file');
            return;
        }
        const last10Lines = data.split('\n').slice(-1).join('\n');
        socket.emit('logUpdate', last10Lines);
    });

    socket.on('disconnect', () => {
        console.log('Client disconnected');
        clients = clients.filter(client => client !== socket);
    });
});

server.listen(port, () => {
    console.log(`Server is listening on http://localhost:${port}`);
});
