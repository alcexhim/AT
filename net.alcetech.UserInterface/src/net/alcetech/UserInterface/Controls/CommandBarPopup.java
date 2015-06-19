package net.alcetech.UserInterface.Controls;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.*;

import net.alcetech.Core.*;
import net.alcetech.UserInterface.Borders.ShadowPopupBorder;
import net.alcetech.UserInterface.Theming.Theme;

public class CommandBarPopup extends JWindow implements WindowListener, WindowFocusListener, FocusListener
{
	private Command _cmd = null;
	public CommandBarPopup(CommandBar parent, Command cmd)
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
		
		this.addWindowListener(this);
		this.addWindowFocusListener(this);
		this.getContentPane().addFocusListener(this);
		
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

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isFocusable()
	{
		return true;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		this.toFront();
		this.requestFocus();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
