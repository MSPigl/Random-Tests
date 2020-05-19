import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Drawing extends JApplet
{
	private static final long serialVersionUID = -3969699899491077333L;
	
	ArrayList<Integer> Xs, Ys;
	ArrayList<Point> points;
	
	Polygon poly;
	boolean drawPoly = false;
	boolean drawLine = false;
	
	public boolean reset = false;
	
	public void init()
	{
		Xs = new ArrayList<>();
		Ys = new ArrayList<>();
		points = new ArrayList<>();
		
		addMouseListener(new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					if (e.getClickCount() == 2)
					{
						points.add(e.getPoint());
						Xs.add(e.getX());
						Ys.add(e.getY());
						showStatus("Point added at (" + e.getX() + ", " + e.getY() + ")");
					}
				}
				else if (e.getButton() == MouseEvent.BUTTON3)
				{
					int[] x = new int[Xs.size()];
					for (int i = 0; i < x.length; i++)
					{
						x[i] = Xs.get(i);
					}
					
					int[] y = new int[Ys.size()];
					for (int i = 0; i < y.length; i++)
					{
						y[i] = Ys.get(i);
					}
					
					String[] options = {"Draw Polygon", "Draw Line"};
					int choice = JOptionPane.showOptionDialog(null, "Choose what to draw", "Options", 0, 0, null, options, null);
					
					if (choice == 0)
					{
						poly = new Polygon(x, y, x.length);
						drawPoly = true;
						showStatus("Drawing Polygon");
					}
					else
					{
						drawLine = true;
						showStatus("Drawing Line");
					}
					
					points.clear();
					Xs.clear();
					Ys.clear();
				}
				else
				{
					reset = true;
				}
				
				repaint();
			}
		});
		
	}
	
	public void paint(Graphics g)
	{
		if (reset)
		{
			g.setColor(Color.WHITE);
			super.paint(g);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			reset = false;
		}
		
		g.setColor(Color.BLUE);
		
		for (Point p: points)
		{
			g.fillOval(p.x, p.y, 2, 2);
		}
		
		if (drawPoly)
		{
			g.fillPolygon(poly);
			drawPoly = false;
		}
		
		if (drawLine)
		{
			try
			{
				for (int i = 1; i < points.size(); i++)
				{
					Point p0 = points.get(i);
					Point p1 = points.get(i - 1);
					g.drawLine(p1.x, p1.y, p0.x, p0.y);
					//Thread.sleep(500);
					drawLine = false;
				}
			}
			catch(Exception e)
			{
				
			}
		}
	}
}
