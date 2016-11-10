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

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import jmarkdown.window.Window;

/**
 *
 * @author rousseaua
 */
public class HelpMenu extends AbstractMenu{
    
    private final JMenuItem syntax = new JMenuItem("Markdown Syntax");
    private final JMenuItem about = new JMenuItem("About");
    private final Desktop desktop = Desktop.getDesktop() ;
    
    public HelpMenu(Window newWindow) {
        super("Help", newWindow);
        this.add(syntax).addActionListener(new HelpSyntaxListener());
        this.add(about).addActionListener(new HelpAboutListener());
    }
    
    class HelpSyntaxListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {openUrl("https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet");}
    }
    class HelpAboutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) { openUrl("https://github.com/madeindjs/jMarkdown");}
    }
    
    private void openUrl(String url){
        try {
            desktop.browse(new URI(url));
        } catch (URISyntaxException ex) {
            Logger.getLogger(HelpMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelpMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
