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
        String stringSelected = getSelectedText();
        // check if something is selected
        if(stringSelected == null){ //nothing selected
            insert("****", getCaretPosition());
        }else{ // something selected
            insert("**"+stringSelected+"**", getSelectionStart(), getSelectionEnd() );
            
        }
    }
    
    public void italicify(){
        insert("**", getCaretPosition());
    }
    
    /**
     * Insert the given string at the given position & set the cursor in the middle of the string
     * @param string as the text to insert
     * @param position as the position to insert the string
     */
    private void insert(String string, int position){
        String content = this.getText();
        content = content.substring(0, position)+string+content.substring(position, content.length());
        this.setText(content);
        this.setCaretPosition(position+string.length()/2);
    }
    
    /**
     * Insert the given string in the given positions and replace the text betwen them.
     * Then set the cursor in the middle of the string
     * @param string string as the text to insert
     * @param positionStart as the begening position to insert the string
     * @param positionEnd as the ending position to insert the string
     */
    private void insert(String string, int positionStart, int positionEnd){
        String content = this.getText();
        // get the text
        content = content.substring(0, positionStart)+string+content.substring(positionEnd, content.length());
        this.setText(content);
        this.setCaretPosition(positionStart+string.length());
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
