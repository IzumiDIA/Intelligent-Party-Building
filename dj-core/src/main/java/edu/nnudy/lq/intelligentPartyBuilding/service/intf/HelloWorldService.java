package edu.nnudy.lq.intelligentPartyBuilding.service.intf;

public interface HelloWorldService {
	default String serveWorld() {
		return "Hello";
	}
}
