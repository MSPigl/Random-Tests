import java.util.Random;

/**
 * This class simulates the board game Chutes and Ladders
 * 
 * @author Matthew Pigliavento 
 * @version 01/23/2017
 */
public class ChutesAndLadders
{
    // instance variables
    private int numSpins;   //holds number of total spins
    private int numChutes;  //holds number of total chutes encountered
    private int numLadders; //holds number of total ladders encountered
    private int simCount;   //holds the number of times the simulation was run
    private int[] board;    //represents the game board

    /**
     * Constructor for objects of type ChutesAndLadders
     */
    public ChutesAndLadders()
    {
        numSpins = 0;
        numChutes = 0;
        numLadders = 0;
        simCount = 0;
        board = new int[101];
    }

    /**
     * Simulates a single-player game of Chutes and Ladders a given number of times
     * 
     * @param simulationCount the number of times to run the simulation
     */
    public void runSimulation(int simulationCount)
    {
        Random spinner = new Random();
        // runs the simulation a specified number of times
        for (int i = 0; i < simulationCount; i++)
        {
            //tracks the player's position on the "board"
            int position = 0;
            // game loop continues until the player reaches space 100
            while (true)
            {
                //simulates a spinner, with values ranging from 1 to 6 (inclusive)
                int spin = spinner.nextInt(6) + 1;
                numSpins++;
                //checks if the player will encounter a chute, ladder, or has reached space 100
                //if player encounters a chute or ladder, player position is adjusted accordingly
                if ((position + spin) <= 100)
                {                       
                    if ((position + spin) == 1)
                    {
                        position = 38;
                        numLadders++;
                    }
                    else if ((position + spin) == 4)
                    {
                        position = 14;
                        numLadders++;
                    }
                    else if ((position + spin) == 9)
                    {
                        position = 31;
                        numLadders++;
                    }
                    else if ((position + spin) == 16)
                    {
                        position = 6;
                        numChutes++;
                    }
                    else if ((position + spin) == 21)
                    {
                        position = 42;
                        numLadders++;
                    }
                    else if ((position + spin) == 28)
                    {
                        position = 84;
                        numLadders++;
                    }
                    else if ((position + spin) == 36)
                    {
                        position = 44;
                        numLadders++;
                    }
                    else if ((position + spin) == 48)
                    {
                        position = 26;
                        numChutes++;
                    }
                    else if ((position + spin) == 49)
                    {
                        position = 11;
                        numChutes++;
                    }
                    else if ((position + spin) == 51)
                    {
                        position = 67;
                        numLadders++;
                    }
                    else if ((position + spin) == 56)
                    {
                        position = 53;
                        numChutes++;
                    }
                    else if ((position + spin) == 62)
                    {
                        position = 19;
                        numChutes++;
                    }
                    else if ((position + spin) == 64)
                    {
                        position = 60;
                        numChutes++;
                    }
                    else if ((position + spin) == 71)
                    {
                        position = 91;
                        numLadders++;
                    }
                    else if ((position + spin) == 80) 
                    {
                        position = 100;
                        numLadders++;
                    }
                    else if ((position + spin) == 87)
                    {
                        position = 24;
                        numChutes++;
                    }
                    else if ((position + spin) == 93)
                    {
                        position = 73;
                        numChutes++;
                    }
                    else if ((position + spin) == 95)
                    {
                        position = 75;
                        numChutes++;
                    }
                    else if ((position + spin) == 98)
                    {
                        position = 78;
                        numChutes++;
                    }
                    else
                    {
                        position += spin;                    
                    }
                    //breaks the while-loop if player position is exactly 100
                    if (position == 100)
                    {                     
                        break;
                    }
                    board[position]++;
                }
            }
            simCount++;
        }
    }

    /**
     * Gets the average number of spins it takes to reach space 100
     * @return the average number of spins
     */
    public double getAverageSpins()
    {
        return (numSpins * 1.0)/simCount;
    }

    /**
     * Gets the average number of chutes taken before reaching space 100
     * @return the average number of chutes
     */
    public double getAverageChutes()
    {
        return (numChutes * 1.0)/simCount;
    }

    /**
     * Gets the average number of ladders taken before reaching space 100
     * @return the average number of ladders
     */
    public double getAverageLadders()
    {
        return (numLadders * 1.0)/simCount;
    }

    /**
     * Gets the most commonly occupied space of the board
     * @return the index of the most commonly visited space
     */
    public int getMostCommonSpace()
    {
        int largestIndex = 0;
        //compares array values from board[1] to board[99] (inclusive) to find the most commonly landed-on space
        for (int i = 1; i < 101; i++)
        {
            if (board[i] > board[largestIndex])
            {
                largestIndex = i;
            }
        }
        return largestIndex; 
    }

    /**
     * Main method for class ChutesAndLadders
     * @param args array of command line arguments
     */
    public static void main(String[] args)
    {
        ChutesAndLadders play = new ChutesAndLadders();
    }
}