import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class HiMom extends JApplet
{
   private int height;
   private int width;
   
   public void start()
   {
       height = getHeight();
       width = getWidth();
   }
   
   public void init()
   {
       setBackground(Color.pink);
   }
   
   public void paint(Graphics g)
   {
       g.drawString("Hi mom!", height/2, width/2);
   }
}
