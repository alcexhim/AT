package net.alcetech.UserInterface.Controls;

import java.awt.event.*;

import javax.swing.*;

import net.alcetech.Core.*;

public class Window extends JFrame implements ActionListener, WindowListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8818390338655566157L;
	
	public Window()
	{
		this.addWindowListener(this);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationByPlatform(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	/**
	 * Invoked when the Window is set to be the active Window.
	 */
	public void windowActivated(WindowEvent e)
	{
		
	}
	/**
	 * Invoked when a window has been closed as the result of calling dispose on the window.
	 */
	public void windowClosed(WindowEvent e)
	{
		OnClosed(EventArgs.Empty);
	}
	/**
	 * Invoked when the user attempts to close the window from the window's system menu.
	 */
	public void windowClosing(WindowEvent e)
	{
		CancelEventArgs ce = new CancelEventArgs();
		OnClosing(ce);
		if (ce.isCanceled()) return;
		
		this.dispose();
	}
	/**
	 * Invoked when a Window is no longer the active Window.
	 */
	public void windowDeactivated(WindowEvent e)
	{
		
	}
	/**
	 * Invoked when a window is changed from a minimized to a normal state.
	 */
	public void windowDeiconified(WindowEvent e)
	{
		
	}
	/**
	 * Invoked when a window is changed from a normal to a minimized state.
	 */
	public void windowIconified(WindowEvent e)
	{
		
	}
	/**
	 * Invoked the first time a window is made visible.
	 */
	public void windowOpened(WindowEvent e)
	{
		
	}
	
	protected void OnClosing(CancelEventArgs e)
	{
		
	}
	protected void OnClosed(EventArgs e)
	{
		
	}
}
