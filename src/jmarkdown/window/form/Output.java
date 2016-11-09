/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.form;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import jmarkdown.window.menubar.FileMenu;

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
        
        StyleSheet css = kit.getStyleSheet();
        css.addStyleSheet(new GithubMarkdownStyleSheet());
    }
    
}
