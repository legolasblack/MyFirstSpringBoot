package com.marketAP.Proyecto1.models;

public class UserDto extends User {

    private String message;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto() {
        super();
    }

    public UserDto(String name, String lastName, int age, String message) {
        super(name, lastName, age);
        this.message = message;
    }

    public UserDto(String name, String lastName, int age) {
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
