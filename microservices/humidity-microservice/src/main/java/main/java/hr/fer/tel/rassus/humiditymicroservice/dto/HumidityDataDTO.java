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

    public Integer readyToSend() {
        try {
            return Integer.parseInt(currentReading);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("Ovo nije broj: " + currentReading);
        }

    }
}
