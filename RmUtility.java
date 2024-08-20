import java.io.File;

public class RmUtility{
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("Please mention a directory or file to be deleted \n Usage: java RmUtility <file/directory name> ");
    }
    else
    {
      String dirname = args[0];
      File dir = new File(dirname);
      boolean success = dir.delete();
      if(success)
      {
        System.out.println("Successfully deleted "+ dirname);
      }
      else
      {
        System.out.println("Error deleting file");
      }

    }

  }
}