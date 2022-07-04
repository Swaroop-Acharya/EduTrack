package com.example.edutrack;

public class MainModel  {
        String Title, Mark;


    public  MainModel(){}

    public MainModel(String title, String mark) {
        Title = title;
        Mark = mark;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }
}
