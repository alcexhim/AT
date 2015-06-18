package net.alcetech.UserInterface.Theming;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.UIManager;

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
	
	private String mvarLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
	public String getLookAndFeelClassName() { return mvarLookAndFeelClassName; }
	
	public void drawMenuBarBackground(Graphics g, Rectangle rectangle)
	{
		g.setColor(mvarColorScheme.getColor("MenuBarBackground").toAwtColor());
		g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

}
