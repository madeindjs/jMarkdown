/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Represent the Calculator Window
 * @author rousseaua
 */
public class Window extends JFrame{
    
    public Window(String title) {
        this.setTitle(title);
        this.setSize(300,300);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }        

    public void display(){
        this.setVisible(true);
    }
    
}
