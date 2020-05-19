import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import java.util.Random;

import javax.swing.JApplet;

public class Brightness extends JApplet
{	
	public Color background;
	
	public void init()
	{		
		Random ran = new Random();
		background = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					darken();
				}
				else if (e.getButton() == MouseEvent.BUTTON3)
				{
					brighten();
				}
				else
				{
					Random ran = new Random();
					background = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
				}
				
				repaint();
			}
		});
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(background);
		
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void darken()
	{
		int red = background.getRed();
		int green = background.getGreen();
		int blue = background.getBlue();
				
		red = (red - 10 < 0) ? 0 : (red - 10);
		green = (green - 10 < 0) ? 0 : (green - 10);
		blue = (blue - 10 < 0) ? 0 : (blue - 10);
		
		background = new Color(red, green, blue);
	}
	
	public void brighten()
	{
		int red = background.getRed();
		int green = background.getGreen();
		int blue = background.getBlue();
				
		red = (red + 10 > 255) ? 255 : (red + 10);
		green = (green + 10 > 255) ? 255 : (green + 10);
		blue = (blue + 10 > 255) ? 255 : (blue + 10);
		
		background = new Color(red, green, blue);
	}
}