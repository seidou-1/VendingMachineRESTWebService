/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

/**
 *
 * @author laptop
 */
public class BookPublishingSystem {
    
    private int isbn;
    private String publisher;
    private String author;

    public int getIsbn() {
        return isbn;
    }

    //Making isbn read only so it can't be changed
    
//    public void setIsbn(int isbn) {
//        this.isbn = isbn;
//    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    
}
