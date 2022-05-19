package com.ccorp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ErrorMessage {
    private Date currentDate;
    private String message;
    private int status;
    private String description;

    public ErrorMessage( int status, Date currentDate, String message, String description) {
        this.status = status;
        this.currentDate = currentDate;
        this.message = message;
        this.description = description;
    }
}
