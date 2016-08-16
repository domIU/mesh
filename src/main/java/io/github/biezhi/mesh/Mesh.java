package io.github.biezhi.mesh;

import java.util.Collection;

import io.github.biezhi.mesh.scheduler.Scheduler;
import io.github.biezhi.mesh.spider.Spider;

public class Mesh {
	
	public static Scheduler lets(Spider spider, String ... baseUrl){
		return new Scheduler(baseUrl, spider);
	}
	
	public static Scheduler lets(Spider spider, Collection<String> baseUrls){
		return new Scheduler(baseUrls.toArray(new String[baseUrls.size()]), spider);
	}
	
}
