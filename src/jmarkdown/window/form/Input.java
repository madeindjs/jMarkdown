/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.form;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import observer.Observer;

/**
 *
 * @author rousseaua
 */
public class Input extends JTextArea implements observer.Observable, KeyListener{
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Font font = new Font("Verdana", Font.PLAIN, 12);

    public Input() {
        super();
        this.addKeyListener(this);
        this.setFont(font);
        this.setLineWrap(true);
    }
    
    /**
     * Append 
     * @param string 
     */
    @Override
    public void append(String string) {
        super.append(string);
        this.updateObserver(string);
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void updateObserver(String signal) {
        for(Observer obs : observers){
            obs.update(signal);
        }
    }

    @Override
    public void deleteObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    public void keyPressed(KeyEvent ke) { }

    @Override
    public void keyReleased(KeyEvent ke) {
        this.updateObserver(Character.toString(ke.getKeyChar()));
    }
   
    
}
