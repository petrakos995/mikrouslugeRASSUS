package hr.fer.lab.rassus.aggregatormicroservice;

import java.net.ConnectException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.netflix.discovery.shared.transport.TransportException;

@EnableDiscoveryClient
@SpringBootApplication
public class AggregatorMicroserviceApplication {

	public static void main(String[] args) throws ConnectException {
		System.setProperty("spring.cloud.bootstrap.enabled","true");
		SpringApplication.run(AggregatorMicroserviceApplication.class, args);
	}

}
