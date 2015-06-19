package net.alcetech.UserInterface.Theming;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

import javax.imageio.ImageIO;
import javax.swing.UIManager;

import net.alcetech.Core.Application;
import net.alcetech.UserInterface.*;
import net.alcetech.UserInterface.Theming.BuiltinThemes.*;

public abstract class Theme
{
	private static Theme mvarDefaultTheme = new VisualStudio2012Theme();
	public static Theme getDefaultTheme() { return mvarDefaultTheme; }
	
	private ColorScheme mvarColorScheme = null;
	public ColorScheme getColorScheme() { return mvarColorScheme; }
	public void setColorScheme(ColorScheme value) { mvarColorScheme = value; }
	
	private String mvarName = "";
	public String getName() { return mvarName; }
	public void setName(String value) { mvarName = value; }
	
	public String getBasePath() { return Application.getBasePath() + "/Themes/" + getName(); }
	public String getBasePathWithColorScheme() { return getBasePath() + "/ColorSchemes/" + mvarColorScheme.getName(); }
	
	private String mvarLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
	public String getLookAndFeelClassName() { return mvarLookAndFeelClassName; }
	
	private Metrics mvarMetrics = new Metrics();
	public Metrics getMetrics() { return mvarMetrics; }
	
	public void drawCommandBarBackground(Graphics g, Rectangle rectangle)
	{
		g.setColor(mvarColorScheme.getColor("MenuBarBackground").toAwtColor());
		g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}
	public void drawGrip(Graphics g, Rectangle rect)
	{
		BufferedImage image = new BufferedImage(4, 4, BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = image.createGraphics();
		
		g2d.setColor(getColorScheme().getColor("Grip.Background").toAwtColor());
		g2d.fillRect(0, 0, 4, 4);
		
		g2d.setColor(getColorScheme().getColor("Grip.Foreground").toAwtColor());
		g2d.drawLine(0, 0, 3, 3);

		g2d.setColor(getColorScheme().getColor("Grip.Background").toAwtColor());
		for (int i = 1; i < 4; i += 2)
		{
			g2d.drawLine(i, 0, i, 3);
		}
		net.alcetech.UserInterface.Graphics gg = new net.alcetech.UserInterface.Graphics(g);
		gg.fillRectangle(new TextureBrush(image), rect);
	}

}
