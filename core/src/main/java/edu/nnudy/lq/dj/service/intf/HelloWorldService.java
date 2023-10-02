package edu.nnudy.lq.dj.service.intf;

public interface HelloWorldService {
	default String serveWorld() {
		return "Hello";
	}
}
