/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * a complete menubar for jMarkdown
 * @author rousseaua
 */
public class MenuBar extends JMenuBar{
    
    private final JMenu menuFile = new JMenu("File");
    private final JMenuItem mItemNew = new JMenuItem("New");
    private final JMenuItem mItemOpen = new JMenuItem("Open");
    private final JMenuItem mItemSave = new JMenuItem("Save");
    private final JMenuItem mItemSaveAs = new JMenuItem("Save as ...");
    private final JMenuItem mItemExport = new JMenuItem("Export");
    private final JMenuItem mItemQuit = new JMenuItem("Quit");
    
    private final JMenu menuFormat = new JMenu("Format");
    private final JMenuItem mItemBold = new JMenuItem("Bold");
    private final JMenuItem mItemItalic = new JMenuItem("Italic");
    
    private final JMenu menuWindows = new JMenu("Windows");
    private final JCheckBoxMenuItem mItemPreview = new JCheckBoxMenuItem("Preview");
    
    private final JMenu helpWindows = new JMenu("Help");
    private final JMenuItem mItemMdSyntax = new JMenuItem("Markdown Syntax");
    private final JMenuItem mItemAbout = new JMenuItem("About");

   

    public MenuBar() {
        menuFile.add(mItemNew);
        menuFile.add(mItemOpen);
        menuFile.add(mItemSave);
        menuFile.add(mItemSaveAs);
        menuFile.add(mItemExport);
        menuFile.add(mItemQuit);
        this.add(menuFile);
        
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
