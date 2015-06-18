package net.alcetech.Core.Collections.Generic;

import java.util.HashMap;

public class Dictionary<TKey, TValue>
{
	private HashMap<TKey, TValue> _hashMap = new HashMap<TKey, TValue>();
	
	public boolean containsKey(TKey key)
	{
		return _hashMap.containsKey(key);
	}
	public boolean containsValue(TValue value)
	{
		return _hashMap.containsValue(value);
	}
	
	/**
	 * Given the specified key, gets the associated value.
	 * @param key The key to look up in the Dictionary.
	 * @return The value associated with the specified key.
	 */
	public TValue getValueByKey(TKey key)
	{
		return _hashMap.get(key);
	}
	
	public KeyValuePair<TKey, TValue> add(TKey key, TValue value)
	{
		_hashMap.put(key, value);
		return new KeyValuePair<TKey, TValue>(key, value);
	}
	
	public KeyValuePair<TKey, TValue> update(TKey key, TValue value)
	{
		if (_hashMap.containsKey(key)) _hashMap.remove(key);
		_hashMap.put(key, value);
		return new KeyValuePair<TKey, TValue>(key, value);
	}
}
