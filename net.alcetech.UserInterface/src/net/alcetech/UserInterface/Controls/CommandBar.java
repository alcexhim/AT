package net.alcetech.UserInterface.Controls;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import net.alcetech.Core.*;
import net.alcetech.UserInterface.*;
import net.alcetech.UserInterface.Theming.*;

public class CommandBar extends JComponent implements MouseInputListener, MouseWheelListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5694170898071618408L;
	
	public CommandBar()
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
	}
	
	private CommandDisplayStyle mvarDefaultCommandDisplayStyle = CommandDisplayStyle.ImageOnly;
	public CommandDisplayStyle getDefaultCommandDisplayStyle() { return mvarDefaultCommandDisplayStyle; }
	public void setDefaultCommandDisplayStyle(CommandDisplayStyle value) { mvarDefaultCommandDisplayStyle = value; }
	
	private CommandItem.CommandItemCollection mvarCommandCollection = new CommandItem.CommandItemCollection();
	public CommandItem.CommandItemCollection getCommandCollection() { return mvarCommandCollection; }
	
	private int getCommandWidth(CommandReferenceCommandItem crci)
	{
		CommandDisplayStyle displayStyle = getDefaultCommandDisplayStyle();
		if (crci.getDisplayStyle() != CommandDisplayStyle.Default) displayStyle = crci.getDisplayStyle();
		
		int w = 0;
		switch (displayStyle)
		{
			case ImageAndText:
			case TextOnly:
			{
				Command cmd = Application.getCommandCollection().getByName(crci.getCommandName());
				String title = cmd.getTitle();
				if (title.indexOf('_') > -1)
				{
					title = title.substring(0, title.indexOf('_')) + title.substring(title.indexOf('_') + 1);
				}
				FontMetrics metrics = this.getGraphics().getFontMetrics();
				w += metrics.stringWidth(title);
				break;
			}
		}
		return w;
	}
	
	private int menuItemMarginTop = 4;
	private int menuItemMarginBottom = 4;
	
	private int menuItemPaddingLeft = 9;
	private int menuItemPaddingRight = 9;
	private int menuItemPaddingTop = 3;

	public void paintComponent(Graphics g)
	{
		Theme theme = Theme.getDefaultTheme();
		Metrics metrics = theme.getMetrics();
		
		theme.drawCommandBarBackground(g, new Rectangle(0, 0, getWidth(), getHeight()));
		
		int x = 0;
		int y = 0; // who knows
		int w = 0;
		int h = getHeight();
		
		if (mvarFloatable)
		{
			Padding padding = metrics.getCommandBarGripPadding();
			x += padding.getLeft();
			y += padding.getTop();
			h -= padding.getTop() - padding.getBottom();
			
			Rectangle rect = new Rectangle(x, y, metrics.getCommandBarGripSize(), h);
			rect.x += x;
			
			theme.drawGrip(g, rect);
			
			h += padding.getTop() - padding.getBottom();
			x += padding.getRight();
			y -= padding.getTop();
		}
		
		for (CommandItem item : mvarCommandCollection)
		{
			if (CommandReferenceCommandItem.class.isInstance(item))
			{
				CommandReferenceCommandItem crci = (CommandReferenceCommandItem)item;
				
				CommandDisplayStyle displayStyle = getDefaultCommandDisplayStyle();
				if (crci.getDisplayStyle() != CommandDisplayStyle.Default) displayStyle = crci.getDisplayStyle();
				
				Command cmd = Application.getCommandCollection().getByName(crci.getCommandName());
				
				if (crci == _hoverItem)
				{
					g.setColor(Theme.getDefaultTheme().getColorScheme().getColor("MenuItemHoverBackground").toAwtColor());
					g.fillRect(x, y + menuItemMarginTop, getCommandWidth(crci) + menuItemPaddingLeft + menuItemPaddingRight, getHeight() - menuItemMarginTop - menuItemMarginBottom);
				}
				
				switch (displayStyle)
				{
					case ImageAndText:
					case TextOnly:
					{
						String title = cmd.getTitle();
						if (title.indexOf('_') > -1)
						{
							title = title.substring(0, title.indexOf('_')) + title.substring(title.indexOf('_') + 1);
						}
						
						g.setColor(Theme.getDefaultTheme().getColorScheme().getColor("MenuBarForeground").toAwtColor());
						g.drawString(title, x + menuItemPaddingLeft, y + menuItemPaddingTop + 15);
						break;
					}
				}
				
				w = getCommandWidth(crci);
				x += w + menuItemPaddingLeft + menuItemPaddingRight;
			}
		}
	}
	
	private boolean mvarFloatable = true;
	/**
	 * Determines whether this CommandBar is floatable.
	 * @return boolean True if this ComamndBar can be detached from the rafting container, false otherwise.
	 */
	public boolean isFloatable() { return mvarFloatable; }
	public void setFloatable(boolean value) { mvarFloatable = value; }
	
	public Dimension getPreferredSize()
	{
		return new Dimension(0, 26);
	}

	// BEGIN: MouseInputListener methods
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		_hoverItem = null;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		CommandItem item = hitTest(e.getPoint());
		if (item != null)
		{
			CommandReferenceCommandItem crci = (CommandReferenceCommandItem)item;
			Command cmd = Application.getCommandCollection().getByName(crci.getCommandName());
			if (cmd.getCommandCollection().count() > 0)
			{
				// we have child commands, so popup a menu
				System.out.println("has children '" + cmd.getName() + "'");
				
				CommandBarPopup popup = new CommandBarPopup(this, cmd);
				
				int x = this.getLocationOnScreen().x;
				int y = this.getLocationOnScreen().y + this.getHeight();
				
				popup.setLocation(new Point(x, y));
				popup.setVisible(true);
				popup.requestFocus();
			}
			else
			{
				System.out.println("no children '" + cmd.getName() + "'");
			}
		}
		else
		{
			System.out.println("hit test FAILURE");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private CommandItem _hoverItem = null;
	
	public CommandItem hitTest(Point pt)
	{
		return hitTest(pt.x, pt.y);
	}
	public CommandItem hitTest(int x, int y)
	{
		int cx = 0, cy = 0, cw = 0, ch = getHeight();
		for (CommandItem item : mvarCommandCollection)
		{
			if (CommandReferenceCommandItem.class.isInstance(item))
			{
				CommandReferenceCommandItem crci = (CommandReferenceCommandItem)item;
				cw = getCommandWidth(crci) + menuItemPaddingLeft + menuItemPaddingRight;
			}
			if (x >= cx && x <= (cx + cw))
			{
				return item;
			}
			cx += cw;
		}
		return null;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		int x = e.getPoint().x, y = e.getPoint().y;
		CommandItem item = hitTest(x, y);
		if (item != null)
		{
			// item is hot
			_hoverItem = item;
		}
		else
		{
			_hoverItem = null;
		}
		repaint();
	}
	// END: MouseInputListener methods
	
	// BEGIN: MouseWheelListener methods
	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	// END: MouseWheelListener methods
}
