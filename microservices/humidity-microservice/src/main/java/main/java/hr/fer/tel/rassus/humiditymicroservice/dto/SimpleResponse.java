package main.java.hr.fer.tel.rassus.humiditymicroservice.dto;

public class SimpleResponse {
    //
    private Integer response;

    public SimpleResponse(Integer message) {
        this.response = message;
    }

    public Integer getMessage() {
        return response;
    }

    public void setMessage(Integer message) {
        this.response = message;
    }
}
