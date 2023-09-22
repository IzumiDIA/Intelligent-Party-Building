package edu.nnudy.lq.intelligentPartyBuilding.service.impl;

import edu.nnudy.lq.intelligentPartyBuilding.service.intf.HelloWorldService;
import org.springframework.stereotype.Service;

import static java.lang.StringTemplate.STR;

@Service
public class DefaultHelloWorldServiceImpl implements HelloWorldService {
	@Override
	public String serveWorld() {
		return STR."\{HelloWorldService.super.serveWorld()}, the world!";
	}
}
