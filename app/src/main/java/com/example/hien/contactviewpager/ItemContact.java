package com.example.hien.contactviewpager;

/**
 * Created by hien on 8/4/17.
 */

public class ItemContact {
    private int idContact;
    private String namePerson;

    public ItemContact(int idContact, String namePerson) {
        this.idContact = idContact;
        this.namePerson = namePerson;
    }

    public int getIdContact() {
        return idContact;
    }

    public String getNamePerson() {
        return namePerson;
    }
}
