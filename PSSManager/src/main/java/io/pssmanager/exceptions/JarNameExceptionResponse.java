package io.pssmanager.exceptions;

public class JarNameExceptionResponse {

    private String message;

    public JarNameExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
