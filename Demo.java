
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Demo
{
    public static void main(String[] args)
    {
        try
        {
            Scanner file = new Scanner(new File("responses.txt"));

            int yes = 0;
            int no = 0;

            while (file.hasNextLine())
            {
                String line = file.nextLine();
                char response = line.charAt(line.indexOf(" ") + 1);

                if (response == 'y') yes++;
                else no++;
            }

            System.out.println("Yes: " + yes);
            System.out.println("No: " + no);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}

