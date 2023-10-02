package edu.nnudy.lq.dj.service.impl;

import edu.nnudy.lq.dj.service.intf.HelloWorldService;
import org.springframework.stereotype.Service;

import static java.lang.StringTemplate.STR;

@Service
public class DefaultHelloWorldServiceImpl implements HelloWorldService {
	@Override
	public String serveWorld() {
		return STR."\{HelloWorldService.super.serveWorld()}, the world!";
	}
}
