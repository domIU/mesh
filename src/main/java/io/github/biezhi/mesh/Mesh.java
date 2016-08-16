package io.github.biezhi.mesh;

import io.github.biezhi.mesh.scheduler.Scheduler;
import io.github.biezhi.mesh.spider.Spider;

public class Mesh {
	
	public static Scheduler lets(String baseUrl, Spider spider){
		return new Scheduler(baseUrl, spider);
	}
	
}
