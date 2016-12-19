package com.example.alvan.chatproject.model.basic;

/**
 * Created by David Bezalel Laoli on 10/14/2016.
 */
public class User {
    private String id;
    private String email;
    private String name;
    private String photo;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {return email;}

    public void setEmail(String id) {this.id = id;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
