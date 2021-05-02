package io.pssmanager.exceptions;

public class TransactionExceptionResponse {

    private String message;

    public TransactionExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
