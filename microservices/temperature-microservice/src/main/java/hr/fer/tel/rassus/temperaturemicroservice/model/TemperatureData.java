package hr.fer.tel.rassus.temperaturemicroservice.model;

import javax.persistence.*;

@Entity
@Table(name="temperatureData")

public class TemperatureData {
    @Id
    @GeneratedValue
    private Integer ID;

    @Column
    private String temperatureValue;

    public TemperatureData(){}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(String temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

}
