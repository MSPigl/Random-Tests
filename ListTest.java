import java.util.ArrayList;
public class ListTest
{
    public static void removeEven(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) % 2 == 0)
            {
                list.remove(i);
                //i--;
            }
        }
    }
    
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        
        removeEven(list);
        
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
    }
}
