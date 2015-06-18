package net.alcetech.Core.Collections.Generic;

public class KeyValuePair<TKey, TValue>
{
	private TKey _key = null;
	public void setKey(TKey value) { _key = value; }
	public TKey getKey() { return _key; }

	private TValue _value = null;
	public void setValue(TValue value) { _value = value; }
	public TValue getValue() { return _value; }
	
	public KeyValuePair(TKey key, TValue value)
	{
		_key = key;
		_value = value;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (_key != null)
		{
			sb.append(_key.toString());
		}
		else
		{
			sb.append("(null)");
		}
		sb.append(" = ");
		if (_value != null)
		{
			sb.append(_value.toString());
		}
		else
		{
			sb.append("(null)");
		}
		return sb.toString();
	}
}
