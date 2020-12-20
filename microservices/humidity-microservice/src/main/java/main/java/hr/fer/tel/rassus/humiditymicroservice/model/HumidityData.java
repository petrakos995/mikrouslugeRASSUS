package main.java.hr.fer.tel.rassus.humiditymicroservice.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="humidityData")

public class HumidityData {

    @Id
    @GeneratedValue
    private Integer ID;

    @Column
    private String percentageOfHumidy;

    public HumidityData(){}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPercentageOfHumidy() {
        return percentageOfHumidy;
    }

    public void setPercentageOfHumidy(String percentageOfHumidy) {
        this.percentageOfHumidy = percentageOfHumidy;
    }
}
