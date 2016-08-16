package io.github.biezhi.mesh.scheduler;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blade.kit.CollectionKit;
import blade.kit.StringKit;
import blade.kit.http.HttpRequest;
import blade.kit.json.JSONKit;
import io.github.biezhi.mesh.Config;
import io.github.biezhi.mesh.Response;
import io.github.biezhi.mesh.spider.Spider;
import io.github.biezhi.mesh.url.Url;
import io.github.biezhi.mesh.url.UrlManager;

public class WorkerNode implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerNode.class);
	
	private Spider spider;
	private Url url;
	private Config config;
	
	public WorkerNode(Spider spider, Config config, Url url) {
		this.url = url;
		this.spider = spider;
		this.config = (null != config) ? config : Config.get();
	}
	
	@Override
	public void run() {
		
		if(StringKit.isNotBlank(config.name())){
			String threadName = Thread.currentThread().getName().replace("pool", config.name());
			Thread.currentThread().setName(threadName);
		}
		
		int timeout = config.timeout();
		
		LOGGER.debug("_ (:3」∠)_ Request URL => {}", this.url);
		
		Map<String, String> headers = null;

		if(CollectionKit.isNotEmpty(config.headers())){
			headers = config.headers();
			LOGGER.debug("_ (:3」∠)_  Request Headers => {}", JSONKit.toJSONString(headers));
		}
		
		String link = this.url.link();
		
		HttpRequest request = HttpRequest.get(link).connectTimeout(timeout);
		if(null != headers){
			request.headers(headers);
		}
		
		if(link.startsWith("https://")){
			request.trustAllHosts().trustAllCerts();
		}
		
		Response response = new Response(config, request.code());
		String html = request.body();
		response.html(html);
		
		// 发现url
		Collection<String> urls = spider.discover(response);
		if(CollectionKit.isNotEmpty(urls)){
			UrlManager.pushAll(urls);
		}
		spider.parse(response);
	}
	
}
