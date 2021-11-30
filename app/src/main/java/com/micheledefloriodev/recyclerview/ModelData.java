package com.micheledefloriodev.recyclerview;
/*
cardview data


 */
public class ModelData {
    private String name;
    private int userimage;
    public ModelData(){}

    public ModelData(String name, int userimage) {
        this.name = name;
        this.userimage = userimage;
    }

    public String getName() {
        return name;
    }

    public int getUserimage() {
        return userimage;
    }
}
