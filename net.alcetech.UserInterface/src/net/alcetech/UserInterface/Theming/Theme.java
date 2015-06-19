package net.alcetech.UserInterface.Theming;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.UIManager;

import net.alcetech.Core.Application;
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
		
	}

}
