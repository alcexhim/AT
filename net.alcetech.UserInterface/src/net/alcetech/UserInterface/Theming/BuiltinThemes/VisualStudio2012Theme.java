package net.alcetech.UserInterface.Theming.BuiltinThemes;

import net.alcetech.UserInterface.*;
import net.alcetech.UserInterface.Theming.*;

public class VisualStudio2012Theme extends Theme
{
	private static ColorScheme mvarLightColorScheme = new ColorScheme("Light");
	public static ColorScheme getLightColorScheme() { return mvarLightColorScheme; }
	
	private static ColorScheme mvarDarkColorScheme = new ColorScheme("Dark");
	public static ColorScheme getDarkColorScheme() { return mvarDarkColorScheme; }
	
	private static ColorScheme mvarBlueColorScheme = new ColorScheme("Blue");
	public static ColorScheme getBlueColorScheme() { return mvarBlueColorScheme; }
	
	public VisualStudio2012Theme()
	{
		this.setColorScheme(VisualStudio2012Theme.getLightColorScheme());
	}

	private static void initializeLightColorScheme()
	{
		mvarLightColorScheme.setColor("MenuBarBackground", Color.fromHexadecimal("#EEEEF2"));
		mvarLightColorScheme.setColor("MenuBarForeground", Color.fromHexadecimal("#525252"));
		
		mvarLightColorScheme.setColor("MenuItemHoverBackground", Color.fromHexadecimal("#C9DEF5"));
	}
	private static void initializeDarkColorScheme()
	{
		mvarDarkColorScheme.setColor("MenuBarBackground", Color.fromHexadecimal("#2D2D30"));
		mvarLightColorScheme.setColor("MenuBarForeground", Color.fromHexadecimal("#F1F1F1"));
	}
	private static void initializeBlueColorScheme()
	{
		mvarBlueColorScheme.setColor("MenuBarBackground", Color.fromHexadecimal("#2D2D30"));
		mvarLightColorScheme.setColor("MenuBarForeground", Color.fromHexadecimal("#525252"));
	}
	
	static
	{
		initializeLightColorScheme();
		initializeDarkColorScheme();
		initializeBlueColorScheme();
	}

}
