package com.task.user_management_app.error_message;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(int id) {
        super("Couldn't find user with ID = " + id);
    }
}
