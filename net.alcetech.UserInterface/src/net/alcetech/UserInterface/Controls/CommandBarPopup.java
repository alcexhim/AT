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
		this.setMinimumSize(new Dimension(240, 240));
		
		JPanel panel = ((JPanel)this.getContentPane());
		panel.setBorder(new ShadowPopupBorder());
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Theme.getDefaultTheme().getColorScheme().getColor("MenuBackground").toAwtColor());
		g.fillRect(0, 0, getWidth() - ShadowPopupBorder.SHADOW_SIZE, getHeight() - ShadowPopupBorder.SHADOW_SIZE);
	}
}
