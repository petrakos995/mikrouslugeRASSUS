package hr.fer.tel.rassus.temperaturemicroservice;

import hr.fer.tel.rassus.temperaturemicroservice.model.TemperatureData;
import hr.fer.tel.rassus.temperaturemicroservice.repositories.TemperatureDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@EnableDiscoveryClient
@SpringBootApplication
public class TemperaturemicroserviceApplication implements CommandLineRunner {

    @Autowired
    private TemperatureDataRepository temperatureDataRepository;

    public static void main(String[] args) {
    	System.setProperty("spring.cloud.bootstrap.enabled","true");
        SpringApplication.run(TemperaturemicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (temperatureDataRepository.count() == 0){
        	InputStream is = TemperaturemicroserviceApplication.class.getResourceAsStream("/mjerenja.csv");
        	try (BufferedReader br = new BufferedReader(new InputStreamReader(is))){
                String line = br.readLine();
                line = br.readLine();
                while ( line != null){

                    String[] attributes = line.split(",");
                    TemperatureData t = new TemperatureData();
                    if( attributes[2] == null)
                        t.setTemperatureValue("0");
                    else
                        t.setTemperatureValue(attributes[0]);
                    temperatureDataRepository.save(t);
                    line = br.readLine();
                }
            }
        }
    }
}
