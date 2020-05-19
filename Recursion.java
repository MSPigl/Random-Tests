
/**
 * Write a description of class Recursion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion
{
    public static void recursiveHelper()
    {
        String test = "ABCDEFGHIJ";
        recurse(0, test);
    }

    public static void recurse(int index, String str)
    {
        if (index == str.length())
        {
            return;
        }
        System.out.print(str.charAt(index));
        recurse(index + 1, str);
    }

    public static int thing(int n)
    {
        if (n <= 3)
        {
            return n;
        }
        return n * thing(n-1);
    }

    public static int countX(String str) {
        if (str.equals(""))
        {
            return 0;
        }
        if (str.charAt(0) == 'x')
        {
            return 1 + countX(str.substring(1));
        }
        return countX(str.substring(1));
    }

    public static int countHi(String str) {
        if (str.length() < 2)
        {
            return 0;
        }
        if (str.equals("hi"))
        {
            return 1;
        }
        if (str.substring(0,2).equals("hi"))
        {
            return 1 + countHi(str.substring(1));
        }
        return countHi(str.substring(1));
    }
}