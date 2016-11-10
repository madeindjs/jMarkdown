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
package jmarkdown.window.form;

import javax.swing.text.html.StyleSheet;

/**
 * A Stylesheet object loaded with Github Markdown CSS rules
 * https://gist.github.com/andyferra/2554919
 * @author rousseaua
 */
public class GithubMarkdownStyleSheet extends StyleSheet{

    public GithubMarkdownStyleSheet() {
        super();
        
        this.addRule("body { font-family: Helvetica, arial, sans-serif; font-size: 14px; line-height: 1.6; }");
        this.addRule("a {color: #4183C4; }");
        this.addRule("h1, h2, h3, h4, h5, h6 {margin: 20px 0 10px; padding: 0; font-weight: bold;  }");
        this.addRule("h1 tt, h1 code {font-size: inherit; }");
        this.addRule("h2 tt, h2 code {font-size: inherit; }");
        this.addRule("h3 tt, h3 code {font-size: inherit; }");
        this.addRule("h4 tt, h4 code {font-size: inherit; }");
        this.addRule("h5 tt, h5 code {font-size: inherit; }");
        this.addRule("h6 tt, h6 code {font-size: inherit; }");
        this.addRule("h1 {font-size: 28px; color: black; }");
        this.addRule("h2 {font-size: 24px; border-bottom: 1px solid #cccccc; color: black; }");
        this.addRule("h3 {font-size: 18px; }");
        this.addRule("h4 {font-size: 16px; }");
        this.addRule("h5 {font-size: 14px; }");
        this.addRule("h6 {color: #777777; font-size: 14px; }");
        this.addRule("p, blockquote, ul, ol, dl, li, table, pre {margin: 15px 0; }");
        this.addRule("hr {border: 0 none; color: #cccccc; height: 4px; padding: 0; }");
        this.addRule("h1 p, h2 p, h3 p, h4 p, h5 p, h6 p {margin-top: 0; }");
        this.addRule("li p.first { display: inline-block; }");
        this.addRule("ul, ol {padding-left: 30px; }");
        this.addRule("blockquote {border-left: 4px solid #dddddd; padding: 0 15px; color: #777777; }");
        this.addRule("table {padding: 0; }");
        this.addRule("table tr {border-top: 1px solid #cccccc; background-color: white; margin: 0; padding: 0; }");
        this.addRule("table tr:nth-child(2n) {background-color: #f8f8f8; }");
        this.addRule("table tr th {font-weight: bold; border: 1px solid #cccccc; text-align: left; margin: 0; padding: 6px 13px; }");
        this.addRule("table tr td {border: 1px solid #cccccc; text-align: left; margin: 0; padding: 6px 13px; }");
        this.addRule("table tr th :first-child, table tr td :first-child {margin-top: 0; }");
        this.addRule("table tr th :last-child, table tr td :last-child {margin-bottom: 0; }");
        this.addRule("img { max-width: 100%; }");
        this.addRule("code, tt {margin: 0 2px; padding: 0 5px; white-space: nowrap; border: 1px solid #eaeaea; background-color: #f8f8f8; border-radius: 3px; }");
        this.addRule("pre code {margin: 0; padding: 0; white-space: pre; border: none; }");
        this.addRule("pre {background-color: #f8f8f8; border: 1px solid #cccccc; font-size: 13px; line-height: 19px; overflow: auto; padding: 6px 10px; border-radius: 3px; }");
        this.addRule("pre code, pre tt {background-color: transparent; border: none; }");
    }
    
}
