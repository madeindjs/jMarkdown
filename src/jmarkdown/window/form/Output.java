/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.form;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author rousseaua
 */
public class Output extends JEditorPane{
    
    private Font font = new Font("Verdana", Font.PLAIN, 12);

    public Output() {
        super();
        this.setEditable(false);
        this.setFont(font);
        
        
        HTMLEditorKit kit = new HTMLEditorKit();
        this.setEditorKit(kit);
        
        Document doc = kit.createDefaultDocument();
        this.setDocument(doc);
        
    }

}
