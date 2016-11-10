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
    
    /**
     * Make the selection as bold or insert a markdown bold tag
     */
    public void boldify(){ insertTag("**"); }
    
    /**
     * Make the selection as italic or insert a markdown italic tag
     */
    public void italicify(){ insertTag("*"); }
    
    /**
     * Make the selection as code or insert a markdown code tag
     */
    public void codeify(){ insertTag("`"); }
    
    /**
     * Make the selection as code or insert a markdown code tag
     */
    public void codeblockify(){ insertTag("\r```\r"); }
    
    /**
     * A shared function between boldify() and italicify()
     * @param markdownTag to insert
     */
    private void insertTag(String markdownTag){
        String stringSelected = getSelectedText();
        // check if something is selected
        if(stringSelected == null){ //nothing selected
            insert(markdownTag+markdownTag, getCaretPosition());
        }else{ // something selected
            insert(markdownTag+stringSelected+markdownTag, getSelectionStart(), getSelectionEnd() );
            
        }
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
