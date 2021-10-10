package com.djole.mobileappws.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = -2490502527457116910L;

    public UserServiceException(String message) {
        super(message);
    }
}
