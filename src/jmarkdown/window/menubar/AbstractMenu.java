/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import javax.swing.JMenu;
import jmarkdown.window.Window;

/**
 * An abstract class for all Jmenu Item
 * @author rousseaua
 */
public abstract class AbstractMenu extends JMenu{
    
    protected Window window ;

    public AbstractMenu(String newName, Window newWindow) {
        super(newName);
        window = newWindow;
    }
}
