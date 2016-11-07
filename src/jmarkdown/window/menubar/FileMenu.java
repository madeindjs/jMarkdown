/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jmarkdown.window.Window;

/**
 *
 * @author rousseaua
 */
public class FileMenu extends AbstractMenu{
    
    private final JMenuItem create = new JMenuItem("New");
    private final JMenuItem open = new JMenuItem("Open");
    private final JMenuItem save = new JMenuItem("Save");
    private final JMenuItem saveAs = new JMenuItem("Save as ...");
    private final JMenuItem export = new JMenuItem("Export");
    private final JMenuItem quit = new JMenuItem("Quit");

    public FileMenu(Window newWindow) {
        super("File", newWindow);
        
        this.add(create).addActionListener(new FileNewListener());
        this.add(open);
        this.add(save);
        this.add(saveAs);
        this.add(export);
        this.add(quit);
    }
    
    class FileNewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(window.input.isUnsaved()){
                // show a confirm dialog
                int option = JOptionPane.showConfirmDialog(null, 
                        "All non-saved data will be lost", "Begin a new file?",  
                        JOptionPane.OK_CANCEL_OPTION
                );

                // if user confirm, we reset input & output
                if(option == JOptionPane.OK_OPTION){
                    window.input.setText("");
                    window.output.setText("");
                }
            }
        }
    }
    
}
