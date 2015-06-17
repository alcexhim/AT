package net.alcetech.UserInterface.Controls;

import net.alcetech.UserInterface.*;

import javax.swing.JComponent;

public class RibbonTab extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4019174621392475533L;
	
	private String mvarTitle = "";
	public String getTitle() { return mvarTitle; }
	public void setTitle(String value) { mvarTitle = value; }
	
	protected void paintComponent(java.awt.Graphics _g)
	{
		super.paintComponent(_g);
		
		Graphics g = new Graphics(_g);
		g.fillRectangle(Brushes.Blue, 0, 0, 255, 255);
	}
}
