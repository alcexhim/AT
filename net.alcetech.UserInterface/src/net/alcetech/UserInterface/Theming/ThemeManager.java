package net.alcetech.UserInterface.Theming;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import net.alcetech.Core.Application;

public class ThemeManager
{
	private static Theme mvarCurrentTheme = Theme.getDefaultTheme();
	public static Theme getCurrentTheme() { return mvarCurrentTheme; }
	public static void setCurrentTheme(Theme value) { mvarCurrentTheme = value; }
	
	public static String[] GetThemedIconFileNames(String iconName)
	{
		return new String[]
		{
			mvarCurrentTheme.getBasePath() + "/Icons/32x32/" + iconName + ".png",
			mvarCurrentTheme.getBasePath() + "/Icons/16x16/" + iconName + ".png"
		};
	}
	public static ImageIcon GetThemedIcon(String iconName, String size)
	{
		ImageIcon image = new ImageIcon("Themes/" + mvarCurrentTheme.getName() + "/Icons/" + size + "/" + iconName + ".png");
		return image;
	}
	
	public static ArrayList<Image> GetThemedIconImages(String iconName)
	{
		ArrayList<Image> images = new ArrayList<Image>();

		String lastFileName = "";
		String[] files = GetThemedIconFileNames(iconName);
		try
		{
			for (int i = 0; i < files.length; i++)
			{
				File file = new File(files[i]);
				lastFileName = file.getAbsolutePath();
				
				images.add(ImageIO.read(file));
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Could not load icon '" + iconName + "' for theme '" + mvarCurrentTheme.getName()+ "' at '" + lastFileName + "'");
		}
		
		return images;
	}
	
	public static void Initialize()
	{
		/*
		LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < lafs.length; i++)
		{
			System.out.println("found LAF '" + lafs[i].getClassName() + "'");
		}
		*/
		// setTheme(UIManager.getSystemLookAndFeelClassName());
		String className = ThemeManager.getCurrentTheme().getLookAndFeelClassName();
		try
		{
			UIManager.setLookAndFeel(className);
		}
		catch (Exception ex)
		{
			System.out.println("unable to initialize look and feel '" + className + "'");
		}
	}
}
