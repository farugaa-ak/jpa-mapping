package com.example.hibernatejpa.model.onetoone;


import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    private String email;
    private String phone;

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    protected Contact() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
