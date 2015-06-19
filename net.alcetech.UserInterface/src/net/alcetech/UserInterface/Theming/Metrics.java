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
	
	private Padding mvarCommandBarGripPadding = new Padding(3, 3, 4, 4);
	public Padding getCommandBarGripPadding() { return mvarCommandBarGripPadding; }
	public void setCommandBarGripPadding(Padding value) { mvarCommandBarGripPadding = value; }
	
	private int mvarCommandBarGripSize = 5;
	public int getCommandBarGripSize() { return mvarCommandBarGripSize; }
	public void setCommandBarGripSize(int value) { mvarCommandBarGripSize = value; }
}
