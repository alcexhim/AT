package net.alcetech.Core.Collections.ObjectModel;

import net.alcetech.Core.EventArgs;

public class ItemEventArgs<T> extends EventArgs
{
	private T mvarItem = null;
	public T getItem() { return mvarItem; }
	
	private int mvarItemIndex = 0;
	public int getItemIndex() { return mvarItemIndex; }
	
	public ItemEventArgs(T item, int itemIndex)
	{
		mvarItem = item;
		mvarItemIndex = itemIndex;
	}
}
