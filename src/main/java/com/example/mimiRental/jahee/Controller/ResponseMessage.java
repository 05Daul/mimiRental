package com.example.mimiRental.jahee.Controller;

public class ResponseMessage {
    private String message;
    private int status;

    public ResponseMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // Getter, Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
