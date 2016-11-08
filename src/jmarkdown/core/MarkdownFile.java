/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.core;

/**
 * Reprensent the markdown file
 * @author rousseaua
 */
public class MarkdownFile {
    
    private String content ;

    
    public MarkdownFile() {
        content = new String();
    }
    
    
    public void setContent(String newContent){
        this.content = newContent ;
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
     * (not complete yet)
     * @return true file is unsaved
     */
    public boolean isUnsaved(){
        return !this.content.equalsIgnoreCase("");
    }
}
