package com.oklimenko.sampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Do NOT place any *Scan or Enable* annotations here.
 * Place it in /config/*Config class. Otherwise testing uses this class as root scanning and
 * spoils sliced Spring Boot Testing.
 *
 * @author oklimenko@gmail.com
 */
@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
