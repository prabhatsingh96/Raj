package com.example.prabhat.raj.UtilsApp;

/**
 * Created by fluper on 21/3/18.
 */

public class UserDetailForRegistration {

    private String uri;
    private String name;
    private String address;
    private String gender;

    public UserDetailForRegistration() {
    }

    public UserDetailForRegistration(String uri, String name) {
        this.uri = uri;
        this.name = name;

    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
