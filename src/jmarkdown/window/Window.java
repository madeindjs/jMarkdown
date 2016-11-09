/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window;

import jmarkdown.window.menubar.MenuBar;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import jmarkdown.core.MarkdownFile;
import jmarkdown.window.form.Input;
import jmarkdown.window.form.Output;

/**
 * Represent the Calculator Window
 * @author rousseaua
 */
public class Window extends JFrame implements observer.Observer{
    
    private MenuBar menuBar;
    
    private JSplitPane container; 
    public Input input = new Input();
    public Output output = new Output();
    
    private MarkdownFile mdFile = new MarkdownFile();

    
    public Window(String title) {
        
        menuBar = new MenuBar(this);
        
        // insert objects in main container
        container = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, input, output);
        container.setOneTouchExpandable(true);
        this.setContentPane(container);
        
        // set menu bar
        this.setJMenuBar(menuBar);
        
        // prepare windows
        this.setTitle();
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.addObserver(this);
        
    }
    
    /**
     * update title as this format: "{opened file} - jMarkdown"
     */
    public void setTitle(){
        String newTitle = mdFile.isUnsaved() ? "*" : "";
        newTitle += mdFile.getFilename().concat(" - jMarkdown") ;
        this.setTitle( newTitle );
    }
    
    /**
     * update Markdown file and update title
     * @param newMarkdownFile as new MdFile
     */
    public void setMarkdownFile(MarkdownFile newMarkdownFile){
        this.mdFile = newMarkdownFile;
        this.setTitle();
    }
    
    public MarkdownFile getMarkdownFile(){
        return this.mdFile;
    }

    public void display(){
        this.setVisible(true);
    }
    
    /**
     * Close this windows and terminate script
     */
    public void close(){
        this.setVisible(false);
        System.exit(0);

    }

    @Override
    public void update() {
        mdFile.setContent(input.getText());
        output.setText(mdFile.toHtml());
        this.setTitle();
    }
}
