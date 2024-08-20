import java.io.File;

public class LsUtility {
    public static void main(String[] args) {
        String dirPath = args.length > 0 ? args[0] : ".";
        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Could not list files.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}
