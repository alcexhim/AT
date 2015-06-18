package net.alcetech.Core.Collections.ObjectModel;

import net.alcetech.Core.CancelEventArgs;

public class ItemCancelEventArgs<T> extends CancelEventArgs
{
	private T mvarItem = null;
	public T getItem() { return mvarItem; }
	
	private int mvarItemIndex = 0;
	public int getItemIndex() { return mvarItemIndex; }
	
	public ItemCancelEventArgs(T item, int itemIndex)
	{
		mvarItem = item;
		mvarItemIndex = itemIndex;
	}
}
