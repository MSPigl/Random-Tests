import java.util.Scanner;
/**
 * Write a description of class Ass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ass
{
    public static void main(String[] args)
    {
        int N = 5; //Integer.parseInt(args[0]);
        int total = 0;
        for (int i = 3; i <= N; i++)
        {
            for (int k = 0; k < Math.pow(2,i); k++)
            {
                total++;
            }
        }
        System.out.println(total);
    }
}