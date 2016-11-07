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
public class HelpMenu extends AbstractMenu{
    
    private final JMenuItem syntax = new JMenuItem("Markdown Syntax");
    private final JMenuItem about = new JMenuItem("About");
    
    public HelpMenu(Window newWindow) {
        super("Help", newWindow);
        this.add(syntax);
        this.add(about);
    }
    
}
