/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.*;
/**
 *
 * @author JudeAquino
 */
public class Note implements Serializable {
    private String title;
    private String contents;
    public Note() {
        title = "";
        contents = "";
    }
    public Note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String content) {
        this.contents = content;
    }
}