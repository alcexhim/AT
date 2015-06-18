package net.alcetech.Core.Collections.ObjectModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Collection<T>
{
	private ArrayList<T> _list = new ArrayList<>();
	
	public void add(T item)
	{
		_list.add(item);
	}
	
	public boolean contains(T item)
	{
		return _list.contains(item);
	}
	
	public int count()
	{
		return _list.size();
	}
	
	public T getByIndex(int index)
	{
		if (index < 0 || index > this.count() - 1) throw new IndexOutOfBoundsException();
		return _list.get(index);
	}
	
	public void remove(T item)
	{
		_list.remove(item);
	}
	public void removeAt(int index)
	{
		_list.remove(index);
	}

	public ReadOnlyCollection<T> toReadOnlyCollection()
	{
		return new ReadOnlyCollection<T>(this);
	}
}
