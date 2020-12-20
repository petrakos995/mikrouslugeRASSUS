package main.java.hr.fer.tel.rassus.humiditymicroservice.services;

import main.java.hr.fer.tel.rassus.humiditymicroservice.dto.HumidityDataDTO;
import main.java.hr.fer.tel.rassus.humiditymicroservice.model.HumidityData;
import main.java.hr.fer.tel.rassus.humiditymicroservice.repositories.HumidityDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HumidityDataService {
    @Autowired
    private HumidityDataRepository humidityDataRepository;

    public HumidityDataDTO getCurrentReading(Integer ID){
        if( !(humidityDataRepository.existsById(ID))){
            throw new IllegalArgumentException("Ne postoji mjerenje pod ID brojem:" + ID);
        }
        HumidityDataDTO newData = new HumidityDataDTO(humidityDataRepository.getHumidityDataByID(ID).getPercentageOfHumidy());
        return newData;
    }

}
