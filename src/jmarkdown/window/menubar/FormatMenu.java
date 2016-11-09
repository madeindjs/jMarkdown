/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import jmarkdown.window.Window;

/**
 *
 * @author rousseaua
 */
public class FormatMenu extends AbstractMenu{
    private final JMenuItem bold = new JMenuItem("Bold");
    private final JMenuItem italic = new JMenuItem("Italic");
    private final JMenuItem code = new JMenuItem("Code");
    private final JMenuItem codeBlock = new JMenuItem("Code Block");

    public FormatMenu(Window newWindow) {
        super("Format", newWindow);
        
        bold.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
        this.add(bold).addActionListener(new FormatBoldListener());
        
        italic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
        this.add(italic).addActionListener(new FormatItalicListener());
        
        this.add(code).addActionListener(new FormatCodeListener());
        this.add(codeBlock).addActionListener(new FormatCodeBlockListener());
    }
    
    class FormatBoldListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) { window.input.boldify(); }
    }
    class FormatItalicListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) { window.input.italicify(); }
    }
    class FormatCodeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) { window.input.codeify(); }
    }
    class FormatCodeBlockListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) { window.input.codeblockify();}
    }
}
