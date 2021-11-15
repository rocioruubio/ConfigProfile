package com.ntt.microservicios.ConfigClient.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${some.value}")
	private String myValue;

	@Value("${spring.profiles.active}")
	private String activeProfiles;
	
	@GetMapping(path="/myvalue")
	public String myValue() {
		for (String profileName : activeProfiles.split(",")) {
            if(profileName.equals("dev")) {
            	this.myValue = "Hola soy rocio";
            }else if(profileName.equals("prod")) {
            	this.myValue="Soy tester";
            }
        }
		return this.myValue;
	}

	
}
