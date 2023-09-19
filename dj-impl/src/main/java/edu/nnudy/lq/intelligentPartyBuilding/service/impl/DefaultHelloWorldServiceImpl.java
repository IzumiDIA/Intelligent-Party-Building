package edu.nnudy.lq.intelligentPartyBuilding.service.impl;

import edu.nnudy.lq.intelligentPartyBuilding.service.intf.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class DefaultHelloWorldServiceImpl implements HelloWorldService {
	@Override
	public String serveWorld() {
		return HelloWorldService.super.serveWorld() + ", the world!";
	}
}
