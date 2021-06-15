package com.example.easyfix;

import java.util.HashMap;

public class UserModal {
    private int image;
    private HashMap<String, String>  user;
    public UserModal(int image, HashMap<String, String> user) {
        this.image = image;
        this.user = user;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public HashMap<String, String> getUser() {
        return user;
    }

    public void setUser(HashMap<String, String> name) {
        this.user = user;
    }
}
