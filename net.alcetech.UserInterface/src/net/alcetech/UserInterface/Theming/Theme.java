package net.alcetech.UserInterface.Theming;

import javax.swing.UIManager;

public class Theme
{
	private static Theme mvarDefaultTheme = new Theme("Default");
	public static Theme getDefaultTheme() { return mvarDefaultTheme; }
	
	private String mvarName = "";
	public String getName() { return mvarName; }
	
	private String mvarLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
	public String getLookAndFeelClassName() { return mvarLookAndFeelClassName; }
	
	private Theme(String name)
	{
		mvarName = name;
	}

}
