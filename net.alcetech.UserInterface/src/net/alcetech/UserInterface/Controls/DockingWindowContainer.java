package net.alcetech.UserInterface.Controls;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

import net.alcetech.Core.Collections.Generic.*;

public class DockingWindowContainer extends JComponent implements ActionListener
{
	private DockingWindow.DockingWindowCollection mvarWindowCollection = null;
	public DockingWindow.DockingWindowCollection getWindowCollection() { return mvarWindowCollection; }

	private JToolBar mvarDockingButtonContainer = new JToolBar();
	public JToolBar getDockingButtonContainer() { return mvarDockingButtonContainer; }
	
	private Component mvarSelectedComponent = null;
	public void setSelectedComponent(Component component)
	{
		if (mvarSelectedComponent != null)
		{
			this.remove(mvarSelectedComponent);
		}
		this.add(component, BorderLayout.CENTER);
		mvarSelectedComponent = component;

		this.validate();
		this.repaint();
	}
	
	private Dictionary<JButton, DockingWindow> dict = new Dictionary<JButton, DockingWindow>();
	void associateDockingWindow(JButton toolbarButton, DockingWindow dw)
	{
		if (dict.containsKey(toolbarButton))
		{
			dict.update(toolbarButton, dw);
		}
		else
		{
			dict.add(toolbarButton, dw);
		}
	}
	DockingWindow getAssociatedDockingWindow(JButton toolbarButton)
	{
		return dict.getValueByKey(toolbarButton);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < mvarDockingButtonContainer.getComponentCount(); i++)
		{
			JButton button = (JButton)mvarDockingButtonContainer.getComponent(i);
			button.setSelected(button == e.getSource());
		}
		
		JButton button1 = (JButton)e.getSource();
		setSelectedComponent(getAssociatedDockingWindow(button1).getComponent());
	}
	
	public DockingWindowContainer()
	{
		mvarWindowCollection = new DockingWindow.DockingWindowCollection(this);
		this.setLayout(new BorderLayout());
		
		this.mvarDockingButtonContainer.setFloatable(false);
		
		this.add(mvarDockingButtonContainer, BorderLayout.NORTH);
	}
}
