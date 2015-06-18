package net.alcetech.Core;

import java.nio.file.Paths;

public class Application
{
	private static String _basePath = null;
	public static String getBasePath()
	{
		if (Application._basePath == null)
		{
			Application._basePath = (Paths.get("..").toAbsolutePath().toString());
		}
		return Application._basePath;
	}
	public static void Exit()
	{
		System.exit(0);
	}
	public static void Exit(int exitCode)
	{
		System.exit(exitCode);
	}
}
