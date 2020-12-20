package main.java.hr.fer.tel.rassus.humiditymicroservice;

import main.java.hr.fer.tel.rassus.humiditymicroservice.model.HumidityData;
import main.java.hr.fer.tel.rassus.humiditymicroservice.repositories.HumidityDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HumidityMicroserviceApplication implements CommandLineRunner {

    @Autowired
    private HumidityDataRepository humidityDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(HumidityMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (humidityDataRepository.count() == 0){
            HumidityData h1 = new HumidityData();
            h1.setPercentageOfHumidy("1254");
            //h1.setPercentageOfHumidy();
            //TODO ovdje je potrebno promjeniti ucitavanje iy csv datoteke i da se to spremi
            humidityDataRepository.save(h1);
            HumidityData h2 = new HumidityData();
            h1.setPercentageOfHumidy("5689");
            humidityDataRepository.save(h2);

        }
    }
}
