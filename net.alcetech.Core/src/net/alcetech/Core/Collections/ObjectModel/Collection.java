package net.alcetech.Core.Collections.ObjectModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Collection<T> implements Iterable<T>
{
	private ArrayList<T> _list = new ArrayList<>();
	
	public boolean add(T item)
	{
		ItemCancelEventArgs<T> e = new ItemCancelEventArgs<T>(item, indexOf(item));
		onItemAdding(e);
		if (e.isCanceled()) return false;
		
		_list.add(item);
		onItemAdded(new ItemEventArgs<T>(item, indexOf(item)));
		return true;
	}
	
	public boolean contains(T item)
	{
		return _list.contains(item);
	}
	
	public int indexOf(T item)
	{
		return _list.indexOf(item);
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
	
	public boolean remove(T item)
	{
		ItemCancelEventArgs<T> e = new ItemCancelEventArgs<T>(item, indexOf(item));
		onItemRemoving(e);
		if (e.isCanceled()) return false;
		
		_list.remove(item);
		onItemRemoved(new ItemEventArgs<T>(item, indexOf(item)));
		return true;
	}
	public boolean removeAt(int index)
	{
		T item = getByIndex(index);
		return remove(item);
	}
	
	protected void onItemAdding(ItemCancelEventArgs<T> e)
	{
	}
	protected void onItemAdded(ItemEventArgs<T> e)
	{
	}
	
	protected void onItemRemoving(ItemCancelEventArgs<T> e)
	{
	}
	protected void onItemRemoved(ItemEventArgs<T> e)
	{
	}

	public ReadOnlyCollection<T> toReadOnlyCollection()
	{
		return new ReadOnlyCollection<T>(this);
	}

	@Override
	public Iterator<T> iterator()
	{
		// TODO Auto-generated method stub
		return _list.iterator();
	}
}
