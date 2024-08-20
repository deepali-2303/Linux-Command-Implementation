import java.io.*;

public class touchUtility {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TouchUtility <file>");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        try {
            boolean fileCreated = file.createNewFile();
            if (fileCreated) {
                System.out.println("File created: " + fileName);
            } else {
                boolean updated = file.setLastModified(System.currentTimeMillis());
                if (updated) {
                    System.out.println("File timestamp updated: " + fileName);
                } else {
                    System.out.println("Failed to update timestamp for: " + fileName);
                }
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + fileName);
        }
    }
}

