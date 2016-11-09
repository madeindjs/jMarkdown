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
import javax.swing.JEditorPane;
import observer.Observer;

/**
 *
 * @author rousseaua
 */
public class Input extends JEditorPane implements observer.Observable, KeyListener{
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Font font = new Font("Verdana", Font.PLAIN, 12);

    public Input() {
        super();
        this.addKeyListener(this);
        this.setFont(font);
    }
    
    public void boldify(){
        append("****");
    }
    
    public void italicify(){
        append("**");
    }
    
    
    /**
     * Append String to the content of Markdown file
     * @param string 
     */
    public void append(String string) {
        String content = this.getText().concat(string);
        this.setText(content);
        this.updateObserver();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void updateObserver() {
        for(Observer obs : observers){
            obs.update();
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
        this.updateObserver();
    }
   
    
}
