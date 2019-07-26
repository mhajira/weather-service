package com.mhajira.weatherservice;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class WeatherServiceApplication {
	
	private String[] weather = new String[] { "Windy", "Rainy", "Sunny", "Cloudy" };

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@GetMapping("/weather")
	public String getWeather() {
		int random = ThreadLocalRandom.current().nextInt(0, 4);
		return weather[random];
	}
}
