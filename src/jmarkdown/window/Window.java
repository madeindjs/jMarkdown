/*
 * The MIT License
 *
 * Copyright 2016 rousseaua.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jmarkdown.window;

import jmarkdown.window.menubar.MenuBar;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jmarkdown.core.MarkdownFile;
import jmarkdown.window.form.Input;
import jmarkdown.window.form.Output;

/**
 * Represent the Calculator Window
 * @author rousseaua
 */
public class Window extends JFrame implements observer.Observer{
    
    private MenuBar menuBar;
    
    private JPanel container = new JPanel(); 
    public Input input = new Input();
    public Output output = new Output();
    private GridLayout layout = new GridLayout(1,2);
    
    private MarkdownFile mdFile = new MarkdownFile();

    
    public Window(String title) {
        
        menuBar = new MenuBar(this);
        
        // set GridLayout properties
        layout.setHgap(5);
        layout.setVgap(5);
        container.setLayout(layout);
        
        // insert objects in main container
        container.add(input);
        container.add(output);
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
