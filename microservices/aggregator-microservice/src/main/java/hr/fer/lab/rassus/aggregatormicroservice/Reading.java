package hr.fer.lab.rassus.aggregatormicroservice;

public class Reading {
	private int temperature;
	private int humidity;
	private String temperatureUnit;
	
	@Override
	public String toString() {
		return "Measurement [temperature=" + temperature + temperatureUnit + ", humidity=" + humidity + "]";
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public Reading (int temperature, int humidity, String temperatureUnit) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.temperatureUnit=temperatureUnit;
	}
}
