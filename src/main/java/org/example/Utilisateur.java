package org.example;
public class Utilisateur {
    private String name;
    private String firstname;
    private String mail;
    public Utilisateur(String name, String firstname, String mail) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }


    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return firstname;
    }

    public String getEmail() {
        return mail;
    }
}