package com.example.callrecorder.domain.entities;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class Calls {
    @Override
    public String toString() {
        return
                "Type: " + type + '\n' +
                "Phone number: " + phone + '\n' +
                "Date: " + date + '\n' +'\n'+'\n'
                ;
    }

    private long id;
    private String type;
    private String phone;
    private String date;

    public Calls() {
    }

    public Calls(long id, String type, String phone, String date) {
        this.id = id;
        this.type = type;
        this.phone = phone;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



