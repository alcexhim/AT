package net.alcetech.UserInterface;

public class Color
{
	public static Color fromHexadecimal(String hexadecimal)
	{
		if (hexadecimal.startsWith("#")) hexadecimal = hexadecimal.substring(1);
		String rr = hexadecimal.substring(0, 2);
		String gg = hexadecimal.substring(2, 4);
		String bb = hexadecimal.substring(4, 6);
		return Color.fromRGB(Integer.parseInt(rr, 16), Integer.parseInt(gg, 16), Integer.parseInt(bb, 16));
	}
	public static Color fromRGB(int red, int green, int blue)
	{
		return Color.fromRGBA(red, green, blue, 255);
	}
	public static Color fromRGBA(int red, int green, int blue, int alpha)
	{
		Color color = new Color(red, green, blue, alpha);
		return color;
	}
	
	private double mvarRed = 0.0;
	public double getRedDouble() { return mvarRed; }
	public void setRedDouble(double value) { mvarRed = value; }
	public int getRedByte() { return (int)(mvarRed * 255); }
	public void setRedByte(int value) { mvarRed = (double)value / 255; }
	
	private double mvarGreen = 0.0;
	public double getGreenDouble() { return mvarGreen; }
	public void setGreenDouble(double value) { mvarGreen = value; }
	public int getGreenByte() { return (int)(mvarGreen * 255); }
	public void setGreenByte(int value) { mvarGreen = (double)value / 255; }
	
	private double mvarBlue = 0.0;
	public double getBlueDouble() { return mvarBlue; }
	public void setBlueDouble(double value) { mvarBlue = value; }
	public int getBlueByte() { return (int)(mvarBlue * 255); }
	public void setBlueByte(int value) { mvarBlue = (double)value / 255; }
	
	private double mvarAlpha = 1.0;
	public double getAlphaDouble() { return mvarAlpha; }
	public void setAlphaDouble(double value) { mvarAlpha = value; }
	public int getAlphaByte() { return (int)(mvarAlpha * 255); }
	public void setAlphaByte(int value) { mvarAlpha = (double)value / 255; }
	
	private Color(int red, int green, int blue, int alpha)
	{
		setRedByte(red);
		setGreenByte(green);
		setBlueByte(blue);
		setAlphaByte(alpha);
	}
	private Color(double red, double green, double blue, double alpha)
	{
		setRedDouble(red);
		setGreenDouble(green);
		setBlueDouble(blue);
		setAlphaDouble(alpha);
	}
	public java.awt.Color toAwtColor()
	{
		// TODO Auto-generated method stub
		return new java.awt.Color((float)mvarRed, (float)mvarGreen, (float)mvarBlue, (float)mvarAlpha);
	}
}
