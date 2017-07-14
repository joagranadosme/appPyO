package com.procesosoperaciones.app;

import java.util.UUID;

/**
 * Created by Jonathan on 7/13/2017.
 */

public class Boss {

    private String id;
    private String name;
    private String title;
    private String company;
    private int image;

    public Boss(String name, String title, String company, int image){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.title = title;
        this.company = company;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String toString(){
        return  "Boss{" +
                "Id='" + id + '\'' +
                ", Company='" + company + '\'' +
                ", Name='" + name + '\'' +
                ", Title='" + title + '\'' +
                '}';
    }

}
