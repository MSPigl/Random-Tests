
/**
 * Write a description of class Range here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Range
{
    public Cell[][] contents;
    
    public Range(int upperLeft, int lowerRight, Cell content)
    {
        for (int i = upperLeft; i < lowerRight; i++)
        {
            for (int j = i; j < lowerRight; j++)
            {
                contents[i][j] = content;
            }
        }
    }
}
