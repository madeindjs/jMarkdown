/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.window.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jmarkdown.core.MarkdownFile;
import jmarkdown.core.MyUtils;
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
    
    protected final JFileChooser fileChooser = new JFileChooser();
    

    public FileMenu(Window newWindow) {
        super("File", newWindow);
        
        this.add(create).addActionListener(new FileNewListener());
        this.add(open).addActionListener(new FileOpenListener());
        this.add(save);
        this.add(saveAs);
        this.add(export);
        this.add(quit);
        
        fileChooser.addChoosableFileFilter(new MarkdownFileFilter());
        
        
    }
    
    class FileNewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(window.getMarkdownFile().isUnsaved()){
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
    
    class FileOpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (fileChooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                window.setMarkdownFile(new MarkdownFile(file));
                window.input.setText(window.getMarkdownFile().getContent());
                window.input.updateObserver();
            } else {
                System.out.println("Open command cancelled by user.");
            }
        }
    }
    
    /**
     * a class to filter only Markdown extension file in JFileChooser
     */
    class MarkdownFileFilter extends javax.swing.filechooser.FileFilter{
        
        private String[] allowedExtensions = new String[]{"markdown","mdown","md"};

        public MarkdownFileFilter() {
        }
        
        @Override
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }else{
                String extension = MyUtils.getExtension(file);
                if(extension == null){
                    return false;
                }else{
                    return Arrays.stream(allowedExtensions).anyMatch(extension::equals);
                }
                
            }
        }
        
        /**
         * Create description in JFileChooser
         * @return string as description for input files availabale
         */
        @Override
        public String getDescription() {
            String description = "Markdown file (";
            for(String extension : allowedExtensions){
                description = description + " *." + extension;
            }
            return description + " )";
        }

    }
}
