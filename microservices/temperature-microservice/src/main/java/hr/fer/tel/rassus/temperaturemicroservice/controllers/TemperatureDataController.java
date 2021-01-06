package hr.fer.tel.rassus.temperaturemicroservice.controllers;

import hr.fer.tel.rassus.temperaturemicroservice.dto.TemperatureDataDTO;
import hr.fer.tel.rassus.temperaturemicroservice.services.TemperatureDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/current-reading")
public class TemperatureDataController {
    @Autowired
    private TemperatureDataService temperatureDataService;

    @GetMapping
    public ResponseEntity<Integer> getDataFromThisService(){
        LocalTime localTime = LocalTime.now();

        Integer id = (4* localTime.getHour() + localTime.getMinute()/ 15);
        TemperatureDataDTO message =  temperatureDataService.getCurrentReading(id);
        return ResponseEntity.ok(message.readyToSend());
    }
}
