/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import javax.swing.JCheckBoxMenuItem;
import jmarkdown.window.Window;

/**
 * Reprensent JMenu group for all "Preview"
 * @author rousseaua
 */
public class WindowsMenu extends AbstractMenu{
    
    private final JCheckBoxMenuItem preview = new JCheckBoxMenuItem("Preview");

    public WindowsMenu(Window newWindow) {
        super("Format", newWindow);
        this.add(preview);
    }
}
