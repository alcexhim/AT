package net.alcetech.Core;

public class CommandReferenceCommandItem extends CommandItem
{
	private String mvarCommandName = "";
	public String getCommandName() { return mvarCommandName; }
	public void setCommandName(String value) { mvarCommandName = value; }

	public CommandReferenceCommandItem(String commandName)
	{
		// TODO Auto-generated constructor stub
		setCommandName(commandName);
	}
	
}
