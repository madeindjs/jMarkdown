/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.form;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;

/**
 *
 * @author rousseaua
 */
public class Input extends JTextArea{

    public Input(String defaultValue) {
        super(defaultValue);
        this.addKeyListener(new KeyboardListener());
    }
    
    class KeyboardListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent ke) {
            System.out.println("jmarkdown.JMarkdown.keyTyped("+ke.getKeyChar()+")");
        }

        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
        
    }
    
}
