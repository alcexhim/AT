package net.alcetech.UserInterface.Controls;

import java.awt.Component;

import javax.swing.*;

import net.alcetech.Core.Collections.ObjectModel.*;

public class DockingWindow
{
	static public class DockingWindowCollection extends Collection<DockingWindow>
	{
		private DockingWindowContainer _parent = null;
		public DockingWindowCollection(DockingWindowContainer parent)
		{
			_parent = parent;
		}

		protected void onItemAdded(ItemEventArgs<DockingWindow> e)
		{
			String title = e.getItem().getTitle();
			
			JToolBar buttons = _parent.getDockingButtonContainer();
			JButton button = new JButton(title);
			button.addActionListener(_parent);
			buttons.add(button);
			
			_parent.associateDockingWindow(button, e.getItem());
		}
		protected void onItemRemoved(ItemEventArgs<DockingWindow> e)
		{
			JToolBar buttons = _parent.getDockingButtonContainer();
			buttons.remove(buttons.getComponent(e.getItemIndex()));
		}
		
		public DockingWindow add(String title, Component component)
		{
			DockingWindow item = new DockingWindow();
			item.setTitle(title);
			item.setComponent(component);
			add(item);
			return item;
		}
	}
	
	private String mvarTitle = "";
	public void setTitle(String value) { mvarTitle = value; }
	public String getTitle() { return mvarTitle; }
	
	private Component mvarComponent = null;
	public void setComponent(Component value) { mvarComponent = value; }
	public Component getComponent() { return mvarComponent; }
}
