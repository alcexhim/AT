package net.alcetech.Core;

public class CancelEventArgs extends EventArgs
{
	private boolean mvarCancel = false;
	public boolean isCanceled() { return mvarCancel; }
	public void cancel() { mvarCancel = true; }
}
