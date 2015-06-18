package net.alcetech.UserInterface.Theming.BuiltinThemes;

import net.alcetech.UserInterface.Theming.*;

public class SystemTheme extends Theme
{
	private ColorScheme mvarSystemColorScheme = new ColorScheme("System");
	
	public SystemTheme()
	{
		this.setName("Default");
		this.setColorScheme(mvarSystemColorScheme);
	}

}
