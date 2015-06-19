package net.alcetech.UserInterface;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class TextureBrush extends Brush
{
	private BufferedImage mvarImage = null;
	public BufferedImage getImage() { return mvarImage; }
	public void setImage(BufferedImage value) { mvarImage = value; }
	
	public TextureBrush(BufferedImage image)
	{
		setImage(image);
	}
}
