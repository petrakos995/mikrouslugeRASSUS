package hr.fer.lab.rassus.aggregatormicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;


@RestController
@RequestMapping("/")
public class ReadingResourceController {
	static Application tempApplication;
	static RestInterface tempRest;
	static RestInterface humidityRest;
	final Logger log =LoggerFactory.getLogger(ReadingResourceController.class);
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Value("${tempservice.name}")
	private String temperatureServiceName;

	@Value("${humidityservice.name}")
	private String humidityServiceName;
	
	@Value("{app.shared.attribute}")
	private String shared;
	
	@Value("{temperature.unit}")
	private String temperatureUnit;
	
	
	public ReadingResourceController() {
		
	}

	@GetMapping("/readings")
	public ResponseEntity<String> getMeasurement() {
		boolean success = false;
		if(tempRest == null)  success = setTempApp();
		log.info(shared);
		if(!success) return ResponseEntity.status(500).build();
		success = false;
		if(humidityRest == null)  success = setHumidityApp();
		if(!success) return ResponseEntity.status(500).build();
		
		Integer temperature = tempRest.getCurrentReading();
		Integer humidity = humidityRest.getCurrentReading();
		if(temperature == null || humidity == null) return ResponseEntity.status(500).build();
		
		if(("K").equals(temperatureUnit)) temperature += 273;
		
		Reading reading = new Reading(temperature,humidity);
	    return ResponseEntity.ok(reading.toString());
	}

	private boolean setTempApp() {
		Application application = eurekaClient.getApplication(temperatureServiceName);
		if(application == null) return false;
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String temperatureUrl = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort();
		log.info(temperatureUrl);
		tempRest = new RetrofitImplementation(temperatureUrl);
		return true;
	}
	
	private boolean setHumidityApp() {
		Application application = eurekaClient.getApplication(humidityServiceName);
		if(application == null) return false;
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String humidityUrl = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort();
		log.info(humidityUrl);
		humidityRest = new RetrofitImplementation(humidityUrl);
		return true;
	}
}