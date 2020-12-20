package main.java.hr.fer.tel.rassus.humiditymicroservice.controllers;

import main.java.hr.fer.tel.rassus.humiditymicroservice.dto.HumidityDataDTO;
import main.java.hr.fer.tel.rassus.humiditymicroservice.dto.SimpleResponse;
import main.java.hr.fer.tel.rassus.humiditymicroservice.services.HumidityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/current-reading")
public class HumidityDataController {

    @Autowired
    private HumidityDataService humidityDataService;

    @GetMapping
    public ResponseEntity<SimpleResponse> getDataFromThisService(){
        LocalTime localTime = LocalTime.now();
        //TODO ovdje je potrebno ovo promjeniti kako se ne bi samo prva dva mjerenja pokazivala
        Integer id = (4* localTime.getHour() + localTime.getMinute()/ 15)%2;
        HumidityDataDTO message =  humidityDataService.getCurrentReading(id);
        return ResponseEntity.ok(new SimpleResponse(message.toString()));
    }

}
