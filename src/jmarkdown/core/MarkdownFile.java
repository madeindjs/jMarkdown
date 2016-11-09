/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import jmarkdown.window.menubar.FileMenu;

/**
 * Reprensent the markdown file
 * @author rousseaua
 */
public class MarkdownFile {
    
    private String oldContent = "";
    private String content = "";

    private File file = null;

    
    public MarkdownFile() {
        content = new String();
    }
    
    /**
     * Initialize Markdown object from a Markdown file
     * @param file as a Markdown file
     */
    public MarkdownFile(File newFile){
        Stream<String> lines;
        this.setFile(newFile);
    }
    
    /**
     * Load file content
     * @param newFile 
     */
    public void setFile(File newFile){
        this.file = newFile;
        this.oldContent = "";
        try {
            Files.lines(file.toPath()).forEach(line -> oldContent += line+"\n");
        } catch (IOException ex) {
            Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        content = oldContent;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public void setContent(String newContent){
        this.content = newContent ;
    }
    
    /**
     * @return filename if set else return "untilted.md"
     */
    public String getFilename(){
        if(file == null){
            return "untilted.md";
        }else{
            return file.getName();
        }
    }
    
    /**
     * Convert the content from Markdown to Html
     * @return content encoded in Html
     */
    public String toHtml(){
        String html = com.github.rjeschke.txtmark.Processor.process(content);
        return "<html>"+ html+ "</html>" ;
    }
    
    /**
     * Set the content & convert it to Html 
     * @param newContent as plain text
     * @return content encoded in Html
     */
    public String toHtml(String newContent){
        this.setContent(newContent);
        return this.toHtml();
    }
    
    /**
     * Check if current modifications is unsaved
     * @return true file is unsaved
     */
    public boolean isUnsaved(){
        return !this.content.equals(oldContent);
    }
    
    /**
     * Check if the file can be saved
     * @return true if file can be saved
     */
    public boolean canBeSaved(){
        return (this.file != null);
    }
    
    /**
     * Save content in the file
     * @return true if sucess
     */
    public boolean save(){
        if(this.canBeSaved()){
            try(FileWriter fw = new FileWriter(this.file)) {
                fw.write(content);
                oldContent = content;
                return true;
            } catch (IOException ex) {
                System.out.println("Save file can't be opened");
                return false;
            }
        }else{
            System.out.println("File can't be saved");
            return false;
        }
    }
    
    /**
     * Save content in the given file
     * @param newFile as where you want to save
     * @return true if sucess
     */
    public boolean save(File newFile){
        this.file = newFile;
        return this.save();
    }
}
