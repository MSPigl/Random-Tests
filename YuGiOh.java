import java.util.Scanner;

/**
 * This class facilitates a game of Yu-Gi-Oh!
 * 
 * @author Mathew Pigliavento 
 * @version August 8, 2016
 */
public class YuGiOh
{
    // instance variables
    private String player1;
    private String player2;
    private int player1Health;
    private int player2Health;
    private boolean win;

    /**
     * Constructor for objects of class YuGiOh
     */
    public YuGiOh()
    {
        System.out.println("Welcome to the Yu-Gi-Oh Battle Tracker!\n");
        win = false;
    }

    public void setNames()
    {
        Scanner n = new Scanner(System.in);
        Scanner n2 = new Scanner(System.in);
        Scanner aff = new Scanner(System.in);
        System.out.print("Please enter Player 1's name: ");
        String name1 = n.next();
        player1 = name1;
        System.out.print("Please enter Player 2's name: ");
        String name2 = n2.next();
        player2 = name2;
        System.out.println("You've set Player 1 as " + player1 + " and Player 2 as " + player2 + ", is that correct? (Enter Y to continue, N to re-enter)"); 
        String yOrN = aff.next();
        if (yOrN.equals("N"))
        {
            setNames();
            System.out.println();
        }
    }

    public void setHealth()
    {
        Scanner h = new Scanner(System.in);
        Scanner aff = new Scanner(System.in);
        System.out.println("How many lifepoints for this match?");
        int life = h.nextInt();
        player1Health = life;
        player2Health = life;
        System.out.println("You've set the amount of lifepoints as " + life + ", is that correct? (Enter Y to continue, N to re-enter)");
        String yOrN = aff.next();
        if (yOrN.equals("N"))
        {
            setHealth();
            System.out.println();
        }
    }

    public void player1Turn()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("It's " + player1 + "'s turn!");
        System.out.println("Did " + player2 + " take damage this turn? (Enter Y for yes, N for no)");
        String inn = in.next();
        if (inn.equals("Y"))
        {
            Scanner dmg = new Scanner(System.in);
            System.out.println("How much damage?");
            int damage = dmg.nextInt();
            player2Health = player2Health - damage;
        }
    }

    public void player2Turn()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("It's " + player2 + "'s turn!");
        System.out.println("Did " + player1 + " take damage this turn? (Enter Y for yes, N for no)");
        String inn = in.next();
        if (inn.equals("Y"))
        {
            Scanner dmg = new Scanner(System.in);
            System.out.println("How much damage?");
            int damage = dmg.nextInt();
            player1Health = player1Health - damage;
        }
    }

    public void play()
    {
        while (!win)
        {
            System.out.println();
            System.out.println(player1 + " has " + player1Health + " lifepoints, " + player2 + " has " + player2Health + " lifepoints \n");
            player1Turn();
            if (player2Health <= 0)
            {
                win = true;
                System.out.println(player1 + " defeats " + player2 + "!");
                return;
            }
            player2Turn();
            if (player1Health <= 0)
            {
                win = true;
                System.out.println(player2 + " defeats " + player1 + "!");
                return;
            }
        }
    }

    public static void main(String[] args)
    {
        YuGiOh test = new YuGiOh();
        test.setNames();
        test.setHealth();
        test.play();
    }
}