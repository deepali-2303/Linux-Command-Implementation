import java.io.*;
import java.util.Scanner;

public class Catutility{
  public static void main(String[] args)
  {

    if(args.length == 0)
    {
      System.out.println("Please specify the files to be concatenated");
    }
    else
    {
      try{

        for(String filename : args)
        {
          File files = new File(filename);
          Scanner sc = new Scanner(files);
          while(sc.hasNextLine())
          { 
            System.out.println(sc.nextLine());
          }
          sc.close();
        }

      }
      catch(FileNotFoundException e){
        System.out.println("Error occured " + e);

      }
      
    }
  }
}