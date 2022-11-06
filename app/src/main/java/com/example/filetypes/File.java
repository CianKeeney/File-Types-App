package com.example.filetypes;

import java.io.Serializable;

public class File implements Serializable {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File(String name, String description, String image, String url) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.url = url;
    }

    private String image;
    private String url;

}
