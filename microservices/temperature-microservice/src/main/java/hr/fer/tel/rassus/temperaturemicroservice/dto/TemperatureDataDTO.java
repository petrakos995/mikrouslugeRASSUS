package hr.fer.tel.rassus.temperaturemicroservice.dto;

public class TemperatureDataDTO {
    private String currentReading;


    public TemperatureDataDTO(String currentReading) {
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
