package main.java.hr.fer.tel.rassus.humiditymicroservice.dto;

public class SimpleResponse {
    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
