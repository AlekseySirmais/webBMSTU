package main.java;

public class News {
    private int newsId;
    private String tittle;
    String text;
    String author;

    public News(int newsId, String tittle, String text, String author) {
        this.newsId = newsId;
        this.tittle = tittle;
        this.text = text;
        this.author = author;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
