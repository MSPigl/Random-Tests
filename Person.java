import java.util.Scanner;

public class Person
{
    private String name;
    private int age; 
    private String race;
    
    public Person(String nameIn, int ageIn, String raceIn)
    {
        name = nameIn;
        age = ageIn;
        race = raceIn;
    }
    
    public void setName(String in)
    {
        name = in;
    }
    
    public void setAge(int in)
    {
        age = in;
    }
    
    public void setRace(String in)
    {
        race = in;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getRace()
    {
        return race;
    }
    
    public static void fillArray()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many people do you want to create? ");
        int size = in.nextInt();
        Person[] array = new Person[size];
        for (int i = 0; i < size; i++)
        {
            System.out.println("Please enter a name: ");
            in.next();
            String nameIn = in.nextLine();            
            System.out.println();
            System.out.println("Please enter an age: ");
            int ageIn = in.nextInt();
            System.out.println("Please enter a race: ");
            String raceIn = in.next();
            Person p = new Person(nameIn, ageIn, raceIn);
            array[i] = p;
        }
    }
    
    public static void main(String args[])
    {
        fillArray();
    }
}