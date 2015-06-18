package net.alcetech.UserInterface.Borders;

/*
 * Copyright (c) 2001-2009 JGoodies Karsten Lentzsch. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of JGoodies Karsten Lentzsch nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.AbstractBorder;

/**
 * A border with a drop shadow intended to be used as the outer border
 * of popups. Can paint the screen background if used with heavy-weight
 * popup windows.
 *
 * @author Karsten Lentzsch
 * @author Andrej Golovnin
 * @version $Revision: 1.6 $
 *
 * @see ShadowPopup
 * @see ShadowPopupFactory
 */
public final class ShadowPopupBorder extends AbstractBorder
{

    /**
     * The drop shadow needs 5 pixels at the bottom and the right hand side.
     */
    public static final int SHADOW_SIZE = 5;

  /**
   * The singleton instance used to draw all borders.
   */
  private static ShadowPopupBorder instance = new ShadowPopupBorder();

  /**
   * The drop shadow is created from a PNG image with 8 bit alpha channel.
   */
  private static Image shadow
    = new ImageIcon(ShadowPopupBorder.class.getResource("shadow.png")).getImage();


    // Instance Creation *****************************************************

  /**
   * Returns the singleton instance used to draw all borders.
   */
  public static ShadowPopupBorder getInstance() {
    return instance;
  }


  /**
   * Paints the border for the specified component with the specified
     * position and size.
   */
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

    // draw drop shadow
    g.drawImage(shadow, x + SHADOW_SIZE, y + height - SHADOW_SIZE, x + (SHADOW_SIZE * 2), y + height, 0, SHADOW_SIZE + 1, SHADOW_SIZE, (SHADOW_SIZE * 2) + 1, null, c);
    g.drawImage(shadow, x + (SHADOW_SIZE * 2), y + height - SHADOW_SIZE, x + width - SHADOW_SIZE, y + height, SHADOW_SIZE, SHADOW_SIZE + 1, SHADOW_SIZE + 1, (SHADOW_SIZE * 2) + 1, null, c);
    g.drawImage(shadow, x + width - SHADOW_SIZE, y + SHADOW_SIZE, x + width, y + (SHADOW_SIZE * 2), (SHADOW_SIZE + 1), 0, (SHADOW_SIZE * 2) + 1, SHADOW_SIZE, null, c);
    g.drawImage(shadow, x + width - SHADOW_SIZE, y + (SHADOW_SIZE * 2), x + width, y + height - SHADOW_SIZE, SHADOW_SIZE + 1, SHADOW_SIZE, (SHADOW_SIZE * 2) + 1, SHADOW_SIZE + 1, null, c);
    g.drawImage(shadow, x + width - SHADOW_SIZE, y + height - SHADOW_SIZE, x + width, y + height, SHADOW_SIZE + 1, SHADOW_SIZE + 1, (SHADOW_SIZE * 2) + 1, (SHADOW_SIZE * 2) + 1, null, c);
  }


  /**
   * Returns the insets of the border.
   */
  public Insets getBorderInsets(Component c)
  {
    return new Insets(0, 0, SHADOW_SIZE, SHADOW_SIZE);
  }


    /**
     * Reinitializes the insets parameter with this Border's current Insets.
     * @param c the component for which this border insets value applies
     * @param insets the object to be reinitialized
     * @return the <code>insets</code> object
     */
    public Insets getBorderInsets(Component c, Insets insets)
    {
        insets.left = insets.top = 0;
        insets.right = insets.bottom = SHADOW_SIZE;
        return insets;
    }

}

