package net.alcetech.Core;

import java.nio.file.Paths;

import net.alcetech.Core.Collections.ObjectModel.*;

public class Application
{
	private static Collection<ICommandListener> commandListeners = new Collection<ICommandListener>();
	public static void addCommandListener(ICommandListener commandListener)
	{
		commandListeners.add(commandListener);
	}
	public static ReadOnlyCollection<ICommandListener> getCommandListeners()
	{
		return commandListeners.toReadOnlyCollection();
	}
	
	private static Command.CommandCollection commands = new Command.CommandCollection();
	public static Command.CommandCollection getCommandCollection() { return commands; }
	
	private static String _basePath = null;
	public static String getBasePath()
	{
		if (Application._basePath == null)
		{
			Application._basePath = (Paths.get("..").toAbsolutePath().toString());
		}
		return Application._basePath;
	}
	public static void exit()
	{
		System.exit(0);
	}
	public static void exit(int exitCode)
	{
		System.exit(exitCode);
	}
}
