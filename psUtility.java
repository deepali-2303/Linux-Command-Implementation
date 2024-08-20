

public class psUtility {
    public static void main(String[] args) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("ps", "-e");

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
