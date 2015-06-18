package net.alcetech.Core.Collections.ObjectModel;

import java.util.ArrayList;

public class ReadOnlyCollection<T>
{
	private Collection<T> collection = null;
	
	public boolean contains(T item)
	{
		return collection.contains(item);
	}
	public int count()
	{
		return collection.count();
	}
	public T getByIndex(int index)
	{
		return collection.getByIndex(index);
	}
	
	protected ReadOnlyCollection(Collection<T> collection)
	{
		this.collection = collection;
	}
}
