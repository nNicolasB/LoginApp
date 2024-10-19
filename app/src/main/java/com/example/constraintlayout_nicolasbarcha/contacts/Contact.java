package com.example.constraintlayout_nicolasbarcha.contacts;

public class Contact {
    private String name;
    private String phoneNumber;
    private int image;

    public Contact(String name, String phoneNumber,int image) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImage() {
        return image;
    }
}
