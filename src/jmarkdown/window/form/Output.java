/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.form;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author rousseaua
 */
public class Output extends JLabel{
    
    private Font font = new Font("Verdana", Font.PLAIN, 12);

    public Output() {
        super();
        this.setVerticalAlignment(TOP);
        this.setFont(font);
    }
    
}
