package main.java.hr.fer.tel.rassus.humiditymicroservice.repositories;


import main.java.hr.fer.tel.rassus.humiditymicroservice.model.HumidityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityDataRepository extends JpaRepository<HumidityData,Integer> {
    HumidityData getHumidityDataByID(Integer ID);

}
