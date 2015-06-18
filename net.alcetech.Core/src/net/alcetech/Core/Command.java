package net.alcetech.Core;

import net.alcetech.Core.Collections.ObjectModel.*;

public class Command
{
	static public class CommandCollection extends Collection<Command>
	{
		public Command getByName(String name)
		{
			for (Command item : this)
			{
				if (item.getName() == name) return item;
			}
			return null;
		}
	}
	
	private String mvarName = "";
	public void setName(String value) { mvarName = value; }
	public String getName() { return mvarName; }
	
	private String mvarTitle = "";
	public void setTitle(String value) { mvarTitle = value; }
	public String getTitle() { return mvarTitle; }
	
	public Command(String name, String title)
	{
		mvarName = name;
		mvarTitle = title;
	}
	
	public void execute()
	{
		ReadOnlyCollection<ICommandListener> commandListeners = Application.getCommandListeners();
		int count = commandListeners.count();
		for (int i = 0; i < count; i++)
		{
			ICommandListener icml = commandListeners.getByIndex(i);
			icml.onCommandExecuted(new CommandEventArgs(this));
		}
	}
	
	private Command.CommandCollection mvarCommandCollection = new Command.CommandCollection();
	public Command.CommandCollection getCommandCollection() { return mvarCommandCollection; }
}
