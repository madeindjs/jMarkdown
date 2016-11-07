/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window;

import java.awt.BorderLayout;
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
    
    private JPanel container = new JPanel(); 
    private Input input = new Input("Hello World");
    private Output output = new Output("Hello World");

    
    public Window(String title) {
        this.setTitle(title);
        this.setSize(300,300);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        input.addObserver(this);
        
        container.setLayout(new GridLayout(1,2));
        container.add(input);
        container.add(output);

        this.setContentPane(container);
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
