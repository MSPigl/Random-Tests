

/**
 * Write a description of class ChessRice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessRice
{
    public static void main(String[] args)
    {
        long total = 0;
        long rice = 2;
        for (int i = 1; i < 65; i++)
        {
            System.out.println("Square number: " + i);
            System.out.println("Amount of rice for this square: " + rice);
            total = total + rice;
            rice = rice * 2;
            System.out.println("Total: " + total);
        }
    }
}
