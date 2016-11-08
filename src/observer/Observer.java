/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 * Represent an object who can catch signals
 * @author rousseaua
 */
public interface Observer {
    
    /**
     * Catch the signal from the Observable object
     */
    public void update();
}
