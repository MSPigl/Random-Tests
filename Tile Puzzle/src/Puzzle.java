import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Puzzle extends JApplet
{
	private static final long serialVersionUID = 628098460237434588L;

	Tile[][] grid;
	boolean firstClick = false;
	
	public void init()
	{
		grid = new Tile[5][5];
		
		Random ran = new Random();
		
		for (int i = 0; i < grid.length; i++) 
		{
			for (int j = 0; j < grid.length; j++)
			{
				grid[i][j] = new Tile(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)), i, j);
			}
		}
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				
				if (x == 0 || y == 0 || x >= 50*5 || y >= 50*5)
				{
					showStatus("Invalid point");
					return;
				}
				
				int row = y/50;
				int col = x/50;
				
				int button = e.getButton();
				switch(button)
				{
					case MouseEvent.BUTTON1:
						showStatus("Left-click");
						break;
					case MouseEvent.BUTTON2:
						showStatus("Middle-mouse");
						break;
					case MouseEvent.BUTTON3:
						showStatus("Right-click");
						break;
				}
				
				//showStatus("(" + row + ", " + col + ")");
				
				if (firstClick)
				{
					firstClick = false;
					grid[col][row].selected = true;
					
					if (e.getClickCount() > 1)
					{
						grid[col][row].color = Color.BLACK;
					}
				}
				else
				{
					firstClick = true;
				}
				
				repaint();
			}
		});
	}
	
	public void paint(Graphics g)
	{
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				g.setColor(grid[i][j].color);
				g.fillRect(i*50, j*50, 50, 50);
				
				if (grid[i][j].selected)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.BLACK);
				}
				g.drawRect(i*50, j*50, 50, 50);
				
				grid[i][j].selected = false;
			}
		}
	}
	
	private class Tile
	{
		boolean selected; 
		Color color;
		Point position = new Point();
		
		public Tile(Color c, int x, int y)
		{
			color = c;
			position.setLocation(x, y);
			
			selected = false;
		}
	}
}