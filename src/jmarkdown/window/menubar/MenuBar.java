/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jmarkdown.window.Window;

/**
 * a complete menubar for jMarkdown
 * @author rousseaua
 */
public class MenuBar extends JMenuBar{
    
    private Window window ;
    
    private final JMenu menuFormat = new JMenu("Format");
    private final JMenuItem mItemBold = new JMenuItem("Bold");
    private final JMenuItem mItemItalic = new JMenuItem("Italic");
    
    private final JMenu menuWindows = new JMenu("Windows");
    private final JCheckBoxMenuItem mItemPreview = new JCheckBoxMenuItem("Preview");
    
    private final JMenu helpWindows = new JMenu("Help");
    private final JMenuItem mItemMdSyntax = new JMenuItem("Markdown Syntax");
    private final JMenuItem mItemAbout = new JMenuItem("About");

   

    public MenuBar(Window newWindow) {
        
        this.window = newWindow ;
        
        this.add(new FileMenu(newWindow));
        
        menuFormat.add(mItemBold);
        menuFormat.add(mItemItalic);
        this.add(menuFormat);
        
        menuWindows.add(mItemPreview);
        this.add(menuWindows);
        
        helpWindows.add(mItemMdSyntax);
        helpWindows.add(mItemAbout);
        this.add(helpWindows);
    }
    
    
}
