package com.rest.webservice.bean;

import java.util.Date;

public class ExceptionResponseBean {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponseBean(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
