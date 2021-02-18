package io.pssmanager.exceptions;

public class UserContactExceptionResponse {

    private String userContact;

    public UserContactExceptionResponse(String userContact) {
        this.userContact = userContact;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }
}
