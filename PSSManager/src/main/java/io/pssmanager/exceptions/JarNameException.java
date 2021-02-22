package io.pssmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JarNameException extends RuntimeException{
    public JarNameException(String message) {
        super(message);
    }
}
