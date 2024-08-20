import java.io.File;

public class MkdirUtility{
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("Please enter the name of directory");
    }
    else
    {
      String dirname = args[0];
      File dir = new File(dirname);
      if(dir.exists())
      {
        System.out.println("Directory already exists");
      }
      else
      {
        boolean success = dir.mkdirs();
        if(success)
        {
          System.out.println("Successfully created directory " + dirname);
        }
        else
        {
          System.out.println("Error creating directory");
        }
      }
    }
  }
}