import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Scanner;

class ShowPicture 
{
    public static void main(String args[]) 
    {
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("Mount Fuji.jpg");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
        (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        Scanner in = new Scanner(System.in);
        System.out.println("Type show to display image");
        String input = in.next();
        if (input.equals("show"))
        {
            frame.setVisible(true);
        }        
        else
        {
            System.out.println("Fuck you boi");
            return;
        }
        System.out.println(icon.toString());
        System.out.println("Image height: " + icon.getIconHeight());
        System.out.println("Image width: " + icon.getIconWidth());
    }
}