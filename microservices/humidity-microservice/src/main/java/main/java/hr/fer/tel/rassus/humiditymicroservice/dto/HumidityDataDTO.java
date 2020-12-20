package main.java.hr.fer.tel.rassus.humiditymicroservice.dto;

public class HumidityDataDTO {
    private String currentReading;

    public HumidityDataDTO(String currentReading) {
        this.currentReading = currentReading;
    }

    @Override
    public String toString() {
        return this.currentReading;
    }
}
