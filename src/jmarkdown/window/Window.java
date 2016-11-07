/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window;

import jmarkdown.window.menubar.MenuBar;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        this.setTitle(title);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.addObserver(this);
    }        

    public void display(){
        this.setVisible(true);
    }

    @Override
    public void update(String value) {
        String plainText = input.getText();
        String html = com.github.rjeschke.txtmark.Processor.process(plainText);
        output.setText("<html>"+ html+ "</html>");
    }
    
}
