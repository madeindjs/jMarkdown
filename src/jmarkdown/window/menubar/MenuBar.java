/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import javax.swing.JMenuBar;
import jmarkdown.window.Window;

/**
 * a complete menubar for jMarkdown
 * @author rousseaua
 */
public class MenuBar extends JMenuBar{
    
    private Window window ;
    
    public MenuBar(Window newWindow) {
        this.window = newWindow ;
        
        this.add(new FileMenu(newWindow));
        this.add(new FormatMenu(newWindow));
        this.add(new WindowsMenu(newWindow));
        this.add(new HelpMenu(newWindow));
    }
    
}
