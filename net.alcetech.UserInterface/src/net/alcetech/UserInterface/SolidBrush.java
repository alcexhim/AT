package net.alcetech.UserInterface;

import java.awt.Color;

public class SolidBrush extends Brush
{
	private Color mvarColor;
	public Color getColor() { return mvarColor; }
	public void setColor(Color value) { mvarColor = value; }
	
	public SolidBrush(Color color)
	{
		mvarColor = color;
	}
}
