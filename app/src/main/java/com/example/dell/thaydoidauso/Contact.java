package com.example.dell.thaydoidauso;

public class Contact {
    private String contactName;
    private String contactPhoneNumber;
    private long contactID;
    public Contact(String contactName, String contactPhoneNumber, long contactID){
        this.contactName=contactName;
        this.contactPhoneNumber=contactPhoneNumber;
        this.contactID=contactID;
    }

    public String getContactName(){
        return contactName;

    }

    public String getContactPhoneNumber(){
        return contactPhoneNumber;

    }

    public long getcontactID(){
        return contactID;
    }


}
