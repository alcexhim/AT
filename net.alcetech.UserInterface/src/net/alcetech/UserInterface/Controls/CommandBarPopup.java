package net.alcetech.UserInterface.Controls;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import net.alcetech.Core.*;
import net.alcetech.UserInterface.Borders.ShadowPopupBorder;
import net.alcetech.UserInterface.Theming.Theme;

public class CommandBarPopup extends JWindow
{
	private Command _cmd = null;
	public CommandBarPopup(Command cmd)
	{
		_cmd = cmd;
		this.setBackground(new java.awt.Color(0, 0, 0, 0));
		
		int height = 0;
		height += Theme.getDefaultTheme().getMetrics().getMenuPadding().getTop();
		
		CommandItem.CommandItemCollection coll = cmd.getCommandCollection();
		for (CommandItem ci : coll)
		{
			height += Theme.getDefaultTheme().getMetrics().getCommandItemHeight();
		}

		height += Theme.getDefaultTheme().getMetrics().getMenuPadding().getBottom();
		
		this.setMinimumSize(new Dimension(240, height));
		
		JPanel panel = ((JPanel)this.getContentPane());
		panel.setBorder(new ShadowPopupBorder());
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Theme.getDefaultTheme().getColorScheme().getColor("MenuBackground").toAwtColor());
		g.fillRect(0, 0, getWidth() - ShadowPopupBorder.SHADOW_SIZE, getHeight() - ShadowPopupBorder.SHADOW_SIZE);
		
		g.setColor(Theme.getDefaultTheme().getColorScheme().getColor("MenuForeground").toAwtColor());
		
		int x = Theme.getDefaultTheme().getMetrics().getMenuPadding().getLeft();
		x += 24; // image margin width
		
		int y = Theme.getDefaultTheme().getMetrics().getMenuPadding().getTop() + 14;
		CommandItem.CommandItemCollection coll = _cmd.getCommandCollection();
		for (CommandItem ci : coll)
		{
			if (CommandReferenceCommandItem.class.isInstance(ci))
			{
				CommandReferenceCommandItem crci = (CommandReferenceCommandItem)ci;
				Command cmd = Application.getCommandCollection().getByName(crci.getCommandName());
				
				g.drawString(cmd.getTitle(), x, y);
			}
			y += Theme.getDefaultTheme().getMetrics().getCommandItemHeight();
		}
	}
}
