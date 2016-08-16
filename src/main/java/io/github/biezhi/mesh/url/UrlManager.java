package io.github.biezhi.mesh.url;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UrlManager.class);
	
	private static Queue<Url> urls = new LinkedList<Url>();
	private static Set<String> urlSet = new HashSet<String>();
	
	public static boolean isEmpty(){
		return urls.isEmpty();
	}
	
	public static void push(String url){
		Url urlObj = new Url(url);
		if(!urls.contains(urlObj) && !urlSet.contains(url)){
			LOGGER.debug("(°∀°)ﾉ  Push Url => {}", url);
			urls.add(urlObj);
			urlSet.add(url);
		}
	}
	
	public static void pushAll(Collection<String> urls) {
		for(String url : urls){
			push(url);
		}
	}
	
	public static Url pop(){
		return urls.remove();
	}
	
	public static Queue<Url> urls(){
		return urls;
	}
	
}
