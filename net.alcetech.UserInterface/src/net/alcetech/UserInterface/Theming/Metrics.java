package net.alcetech.UserInterface.Theming;

import net.alcetech.UserInterface.*;

public class Metrics
{
	private Padding mvarMenuPadding = new Padding(2, 2, 2, 2);
	public Padding getMenuPadding() { return mvarMenuPadding; }
	public void setMenuPadding(Padding value) { mvarMenuPadding = value; }
	
	private int mvarCommandItemHeight = 22;
	public int getCommandItemHeight() { return mvarCommandItemHeight; }
	public void setCommandItemHeight(int value) { mvarCommandItemHeight = value; }
}
