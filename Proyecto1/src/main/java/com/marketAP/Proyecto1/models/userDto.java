package com.marketAP.Proyecto1.models;

public class userDto extends User {

    private String message;

    public userDto(String name, String lastName, int age, String message) {
        super(name, lastName, age);
        this.message = message;
    }

    public userDto(String name, String lastName, int age) {
        super(name, lastName, age);

        // TODO Auto-generated constructor stub
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
