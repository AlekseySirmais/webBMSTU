package main.java;

public class Comment {

  private   int id;
    private       int idnews;
   private String author;
    private  String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdnews() {
        return idnews;
    }

    public void setIdnews(int idnews) {
        this.idnews = idnews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment(int id, int idnews, String author, String text) {
        this.id = id;
        this.idnews = idnews;
        this.author = author;
        this.text = text;
    }
}
