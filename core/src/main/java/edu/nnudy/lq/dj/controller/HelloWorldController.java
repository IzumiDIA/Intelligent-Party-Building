package edu.nnudy.lq.dj.controller;

import edu.nnudy.lq.dj.service.intf.HelloWorldService;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@NonNull
	private final HelloWorldService helloWorldService;
	
	public HelloWorldController(final @NonNull HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	@GetMapping(value = "/hello", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String hello() {
		return helloWorldService.serveWorld();
	}
}
