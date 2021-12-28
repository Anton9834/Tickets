package com.hfad.ticket.model;

public class Ticket {

    int id,category;
    String img,title,date,color,text;

    public Ticket(int id, String img, String title, String date, String color,String text, int category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.date = date;
        this.color = color;
        this.text=text;
        this.category=category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
