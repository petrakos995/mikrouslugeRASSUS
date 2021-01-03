package main.java.hr.fer.tel.rassus.humiditymicroservice;

import main.java.hr.fer.tel.rassus.humiditymicroservice.model.HumidityData;
import main.java.hr.fer.tel.rassus.humiditymicroservice.repositories.HumidityDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@EnableDiscoveryClient
@SpringBootApplication
public class HumidityMicroserviceApplication implements CommandLineRunner {

    @Autowired
    private HumidityDataRepository humidityDataRepository;

    public static void main(String[] args) {
    	System.setProperty("spring.cloud.bootstrap.enabled","true");
        SpringApplication.run(HumidityMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (humidityDataRepository.count() == 0){
            Path pathToFile = Paths.get("src/main/resources/mjerenja.csv");
            try (BufferedReader br = Files.newBufferedReader(pathToFile.toAbsolutePath(),
                    StandardCharsets.US_ASCII)) {
                String line = br.readLine();
                line = br.readLine();
                while ( line != null){

                    String[] attributes = line.split(",");
                    HumidityData h = new HumidityData();
                    if( attributes[2] == null)
                        h.setPercentageOfHumidy("0");
                    else
                        h.setPercentageOfHumidy(attributes[2]);
                    humidityDataRepository.save(h);
                    line = br.readLine();
                }
            }
            /*HumidityData h1 = new HumidityData();
            h1.setPercentageOfHumidy("1254");
            //TODO ovdje je potrebno promjeniti ucitavanje iz csv datoteke i da se to spremi
            humidityDataRepository.save(h1);
            HumidityData h2 = new HumidityData();
            h2.setPercentageOfHumidy("5689");
            humidityDataRepository.save(h2);*/

        }
    }
}
