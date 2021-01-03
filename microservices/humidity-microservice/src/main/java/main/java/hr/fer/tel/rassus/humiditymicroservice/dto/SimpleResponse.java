package main.java.hr.fer.tel.rassus.humiditymicroservice.dto;

public class SimpleResponse {
    //
    private Integer responce;

    public SimpleResponse(Integer message) {
        this.responce = message;
    }

    public Integer getMessage() {
        return responce;
    }

    public void setMessage(Integer message) {
        this.responce = message;
    }
}
