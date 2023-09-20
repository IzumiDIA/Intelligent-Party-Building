package edu.nnudy.lq.intelligentPartyBuilding.controller;

import edu.nnudy.lq.intelligentPartyBuilding.service.intf.HelloWorldService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private final HelloWorldService helloWorldService;
	
	public HelloWorldController(final  HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	@GetMapping(value = "/hello", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String hello() {
		return helloWorldService.serveWorld();
	}
}
