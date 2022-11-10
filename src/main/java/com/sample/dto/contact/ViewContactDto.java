package com.sample.dto.contact;

public class ViewContactDto {
    private int contactId;
    private String contact;

    public ViewContactDto() {
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
