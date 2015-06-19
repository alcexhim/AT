package net.alcetech.UserInterface;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;

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
		else if (TextureBrush.class.isInstance(brush))
		{
			TextureBrush tb = (TextureBrush)brush;
			Graphics2D g2d = (Graphics2D)mvarUnderlyingGraphics;
			Rectangle rect = new Rectangle(0, 0, tb.getImage().getWidth(), tb.getImage().getHeight());
			g2d.setPaint(new TexturePaint(tb.getImage(), rect));
		}
		mvarUnderlyingGraphics.fillRect(x, y, width, height);
	}
}
