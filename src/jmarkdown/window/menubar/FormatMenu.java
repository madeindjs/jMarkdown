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
