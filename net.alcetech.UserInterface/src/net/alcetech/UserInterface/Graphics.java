package net.alcetech.UserInterface;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Graphics
{
	private java.awt.Graphics mvarUnderlyingGraphics = null;

	public Graphics(java.awt.Graphics underlyingGraphics)
	{
		mvarUnderlyingGraphics = underlyingGraphics;
	}
	
	public void fillRectangle(Brush brush, Rectangle rect)
	{
		fillRectangle(brush, rect.x, rect.y, rect.width, rect.height);
	}
	public void fillRectangle(Brush brush, int x, int y, int width, int height)
	{
		if (SolidBrush.class.isInstance(brush))
		{
			SolidBrush sb = (SolidBrush)brush;
			Graphics2D g2d = (Graphics2D)mvarUnderlyingGraphics;
			g2d.setPaint(sb.getColor());
		}
		mvarUnderlyingGraphics.fillRect(x, y, width, height);
	}
}
