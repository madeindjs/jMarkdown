/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import javax.swing.JMenuItem;
import jmarkdown.window.Window;

/**
 *
 * @author rousseaua
 */
public class FormatMenu extends AbstractMenu{
    private final JMenuItem mItemBold = new JMenuItem("Bold");
    private final JMenuItem mItemItalic = new JMenuItem("Italic");

    public FormatMenu(Window newWindow) {
        super("Format", newWindow);
        this.add(mItemBold);
        this.add(mItemItalic);
    }
}
