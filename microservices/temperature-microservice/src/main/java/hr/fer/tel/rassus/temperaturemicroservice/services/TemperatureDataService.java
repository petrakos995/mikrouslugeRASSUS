package hr.fer.tel.rassus.temperaturemicroservice.services;

import hr.fer.tel.rassus.temperaturemicroservice.dto.TemperatureDataDTO;
import hr.fer.tel.rassus.temperaturemicroservice.model.TemperatureData;
import hr.fer.tel.rassus.temperaturemicroservice.repositories.TemperatureDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureDataService {
    @Autowired
    private TemperatureDataRepository temperatureDataRepository;

    public TemperatureDataDTO getCurrentReading(Integer ID){
        if( !(temperatureDataRepository.existsById(ID))){
            throw new IllegalArgumentException("Ne postoji mjerenje pod ID brojem:" + ID);
        }
        TemperatureDataDTO newData = new TemperatureDataDTO(temperatureDataRepository.getTemperatureDataByID(ID).getTemperatureValue());
        return newData;
    }
}
