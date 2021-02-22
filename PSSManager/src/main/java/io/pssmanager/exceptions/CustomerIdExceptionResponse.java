package io.pssmanager.exceptions;

public class CustomerIdExceptionResponse {

    private String message;

    public CustomerIdExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
