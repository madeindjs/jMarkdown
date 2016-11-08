/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;


/**
 * Reprensent an object who can emit signal to Observer object
 * @author rousseaua
 */
public interface Observable {
    
    /**
     * Add an observer to Observer list
     * you should create an ArrayList of Observer in your class
     * @param obs 
     */
    public void addObserver(Observer obs);
    
    /**
     * Send a signal to all Observer
     */
    public void updateObserver();
    
    /**
     * Delete a specified Observer
     * @param obs 
     */
    public void deleteObserver(Observer obs);
}
