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
        return "<html>"+
                    "<head>" +
                        "<meta charset=\"utf-8\">\n" +
                        "<title>"+getFilename()+"</title>" +
                    "</head>" +
                "<body>" + html+ "</body>" +
            "</html>";
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
            writeInFile(this.file, content);
            oldContent = content;
            return true;
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
    
    /**
     * Save specific content in a specific file
     * It's a shared method between `save` & `export`
     * @param writeFile as specific file to write
     * @param writeContent as content to writte 
     * @return 
     */
    private boolean writeInFile(File writeFile, String writeContent){
            try(FileWriter fw = new FileWriter(writeFile)) {
                fw.write(writeContent);
                return true;
            } catch (IOException ex) {
                System.out.println("File can't be opened");
                return false;
            } catch(NullPointerException ex){
                return false;
            }
    }
    
    /**
     * Export the Markdown file as Html
     * @param exportFile 
     */
    public boolean export(File exportFile){
        return writeInFile(exportFile, this.toHtml());
    }
}
