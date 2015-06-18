package net.alcetech.UserInterface.Theming;

import net.alcetech.Core.Collections.Generic.*;
import net.alcetech.UserInterface.Color;

public class ColorScheme
{
	private String mvarName = "";
	public String getName() { return mvarName; }
	public void setName(String value) { mvarName = value; }

	public ColorScheme(String name)
	{
		// TODO Auto-generated constructor stub
		setName(name);
	}
	
	private Dictionary<String, Color> colorsByName = new Dictionary<String, Color>();
	public Color getColor(String name)
	{
		return colorsByName.getValueByKey(name);
	}
	public void setColor(String name, Color value)
	{
		colorsByName.update(name, value);
	}

}
