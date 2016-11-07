/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jmarkdown.window.form.Input;

/**
 * Represent the Calculator Window
 * @author rousseaua
 */
public class Window extends JFrame{
    
    private JPanel container = new JPanel(); 
    private Input input = new Input("Hello World");
    private JLabel output = new JLabel("Hello World");

    
    public Window(String title) {
        this.setTitle(title);
        this.setSize(300,300);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        container.setLayout(new GridLayout(1,2));
        container.add(input);
        container.add(output);

        this.setContentPane(container);
    }        

    public void display(){
        this.setVisible(true);
    }
    
}
