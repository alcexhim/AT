package net.alcetech.UserInterface;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class MessageDialog
{
	public static MessageDialogResult ShowDialog(Component owner, String message, String title)
	{
		return ShowDialog(owner, message, title, MessageDialogButtons.OK);
	}
	public static MessageDialogResult ShowDialog(Component owner, String message, String title, MessageDialogButtons buttons)
	{
		int optionType = 0;
		int messageType = JOptionPane.PLAIN_MESSAGE;
		boolean okayOnly = false;
		
		switch (buttons)
		{
			case OK:
			{
				okayOnly = true;
				break;
			}
			case OKCancel:
			{
				optionType = JOptionPane.OK_CANCEL_OPTION;
				break;
			}
			case YesNo:
			{
				optionType = JOptionPane.YES_NO_OPTION;
				break;
			}
			case YesNoCancel:
			{
				optionType = JOptionPane.YES_NO_CANCEL_OPTION;
				break;
			}
		}
		Icon icon = null;
		
		if (okayOnly)
		{
			JOptionPane.showMessageDialog(owner, message, title, messageType, icon);
			return MessageDialogResult.OK;
		}
		
		int retval = JOptionPane.showConfirmDialog(owner, message, title, optionType, messageType, icon);
		switch (retval)
		{
			case JOptionPane.OK_OPTION:
			{
				if (buttons == MessageDialogButtons.YesNo || buttons == MessageDialogButtons.YesNoCancel)
				{
					return MessageDialogResult.Yes;
				}
				return MessageDialogResult.OK;
			}
			case JOptionPane.NO_OPTION:
			{
				return MessageDialogResult.No;
			}
			case JOptionPane.CANCEL_OPTION:
			{
				return MessageDialogResult.Cancel;
			}
		}
		return MessageDialogResult.None;
	}
}
