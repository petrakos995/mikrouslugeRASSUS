package hr.fer.tel.rassus.temperaturemicroservice.repositories;

import hr.fer.tel.rassus.temperaturemicroservice.model.TemperatureData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureDataRepository  extends JpaRepository<TemperatureData,Integer> {
    TemperatureData getTemperatureDataByID(Integer ID);
}
