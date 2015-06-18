package net.alcetech.UserInterface;

public class Padding
{
	private int mvarTop = 0;
	public int getTop() { return mvarTop; }
	public void setTop(int value) { mvarTop = value; }
	private int mvarBottom = 0;
	public int getBottom() { return mvarBottom; }
	public void setBottom(int value) { mvarBottom = value; }
	private int mvarLeft = 0;
	public int getLeft() { return mvarLeft; }
	public void setLeft(int value) { mvarLeft = value; }
	private int mvarRight = 0;
	public int getRight() { return mvarRight; }
	public void setRight(int value) { mvarRight = value; }
	
	public Padding(int all)
	{
		mvarTop = all;
		mvarBottom = all;
		mvarLeft = all;
		mvarRight = all;
	}
	public Padding(int top, int bottom, int left, int right)
	{
		mvarTop = top;
		mvarBottom = bottom;
		mvarLeft = left;
		mvarRight = right;
	}
}
