package net.alcetech.Core;

public class CommandEventArgs extends EventArgs
{
	private Command mvarCommand = null;
	public Command getCommand() { return mvarCommand; }
	
	public CommandEventArgs(Command command)
	{
		mvarCommand = command;
	}
}
