import java.util.Scanner;

public class DoubleLList<T>
{
    // instance variables
    private int length;
    private Node head;
    private Node tail;
            
    // constructor for class DoubleLList
    public DoubleLList()
    {
        length = 0;
        head = null;
        tail = null;
    }
    
    // returns Node at given position
    public Node getNodeAt(int pos)
    {
        if (pos < 1 || pos > length)
        {
            return null;
        }
        Node currentNode = head;
        for (int i = 1; i < pos; i++)
        {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    
    // add Node at end of list
    public boolean add(T entry)
    {
        Node newNode = new Node(entry);
        // checks if list is empty; if so, head and tail points to newNode
        if (length == 0)
        {
            head = newNode;
            tail = newNode;            
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }       
        length++;
        return true;
    }
    
    // add Node at specified position in the list
    public boolean add(T entry, int pos)
    {
        boolean successful = false;
        if (pos >= 1 || pos <= length)
        {
            successful = true;
            length++;
            Node newNode = new Node(entry);
            Node posNode = getNodeAt(pos);
            newNode.next = getNodeAt(pos + 1);
            getNodeAt(pos + 1).prev = newNode;
            newNode.prev = posNode;
            posNode.next = newNode;            
        }
        return successful;
    }
    
    // removes the Node at specified position; returns removed Node's data
    public T remove(int pos)
    {
        T dat = null;
        if (length == 0 || (pos <= 0 || pos > length))
        {
            return dat;
        }
        if (pos == 1)
        {
            head = head.next;
            head.prev = null;
            length--;
            return dat;
        }
        if (pos == length)
        {
            tail = tail.prev;
            tail.next = null;
            length--;
            return dat;
        }
        Node posNode = getNodeAt(pos);
        Node preNode = getNodeAt(pos - 1);
        Node nxtNode = getNodeAt(pos + 1);
        dat = posNode.data;
        preNode.next = nxtNode;
        nxtNode.prev = preNode;
        length--;
        return dat;
    }
    
    public void clear()
    {
        length = 0;
    }
    
    public void print()
    {
        Node currentNode = head;
        for (int i = 1; i < length; i++)
        {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
        System.out.println(tail.data);
    }
    
    private class Node
    {
        // instance variables
        private Node next;
        private Node prev;
        private T data;
        
        // Node at beginning of list
        private Node(T dataIn)
        {
            data = dataIn;
            next = null;
            prev = null;
        }
        
        // General constructor for class Node
        private Node(T dataIn, Node nextNode, Node prevNode)
        {
            data = dataIn;
            next = nextNode;
            prev = prevNode;
        }
    }
    
    public static void main(String[] args)
    {
        DoubleLList<Integer> list = new DoubleLList<Integer>();
        Scanner prompt = new Scanner(System.in);
        System.out.print("Number of Nodes to add to list: ");
        int num = prompt.nextInt();
        for (int i = 0; i < num; i++)
        {
            System.out.print("Value for Node: ");
            int val = prompt.nextInt();
            list.add(val);
        }
        while (true)
        {
            System.out.println("Type 'print' to print the list, 'add' to add a Node to the list, 'clear' to clear the list,\n'remove' to remove a Node, 'end' to stop");
            String com = prompt.next();
            if (com.equals("end"))
            {
                System.out.println("Program ended");
                break;
            }
            else if (com.equals("print"))
            {
                list.print();
            }
            else if (com.equals("add"))
            {
                System.out.print("Enter value to add: ");
                int val = prompt.nextInt();
                list.add(val);
            }
            else if (com.equals("clear"))
            {
                list.clear();
            }
            else if (com.equals("remove"))
            {
                System.out.print("Enter position of Node to remove: ");
                int pos = prompt.nextInt();
                list.remove(pos);
            }
            else
            {
                System.out.println("Command not recognized");
            }
        }
    }
}