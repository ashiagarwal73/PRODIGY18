package com.example.ashi.a1myapplication;

/**
 * Created by shivam on 21/12/17.
 */

public class Details {
    String id;
    int id_image;

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    String image_name;
    public void setImage(String id) {
        this.id = id;
    }
    public void set_id_Image(int id_image) {
        this.id_image = id_image;
    }

    public String getImage() {
        return id;
    }
    public int get_id_Image() {
        return id_image;
    }
}
