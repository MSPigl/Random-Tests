
/**
 * This is the driver for HW #1, Chutes And Ladders Simulation
 * 
 * @author Darren Lim
 * @version 1.0
 */
public class Driver
{
    /**
     * Main method for the Driver.  This uses the same ChutesAndLadders object to
     * run simulations of different lengths.  It also tests how long it takes to
     * generate the output.
     * 
     * @param   args Command Line Arguments
     */
    public static void main(String args[])
    {
        final int UPPER_BOUND = 1_000_000;

        ChutesAndLadders c = new ChutesAndLadders();
        long time = System.currentTimeMillis();
        for (int runLength = 10; runLength <= UPPER_BOUND; runLength *= 10)
        {
            System.out.println("Using " + runLength + " iterations");
            c.runSimulation(runLength);
            System.out.println("Average # of Spins = " + c.getAverageSpins());
            System.out.println("Average # of Chutes = " + c.getAverageChutes());
            System.out.println("Average # of Ladders = " + c.getAverageLadders());
            System.out.println("Most landed upon non-end space is " + c.getMostCommonSpace());
            System.out.println();

        }
        System.out.println("Time elapsed " + (System.currentTimeMillis() - time)/1000.0 + " seconds");

    }
}
