package io.github.biezhi.mesh;

import java.util.HashMap;
import java.util.Map;

public class Config {
	
	/**
	 * 起始url
	 */
	private String baseUrl;
	
	/**
	 * 爬虫名字
	 */
	private String name = "worker";
	
	/**
	 * 超时设置
	 */
	private int timeout = Const.DEFAULT_CONNECT_TIME_OUT;
	
	/**
	 * 任务空闲时等待多久关闭，默认10秒
	 */
	private int waits = Const.DEFAULT_SHUTDOWN_WAIT;
	
	/**
	 * 重试次数
	 */
	private int retry = Const.DEFAULT_RETRY_COUNT;
	
	/**
	 * 线程数
	 */
	private int threads = Const.DEFAULT_WORKDER_THREADS;
	
	/**
	 * 头信息
	 */
	private Map<String, String> headers;
	
	public static Config get() {
		return new Config();
	}
	
	public static Config get(String name) {
		return new Config().name(name);
	}
	
	public Config() {
		this.headers = new HashMap<String, String>();
	}
	
	public Config timeout(int timeout){
		this.timeout = timeout;
		return this;
	}
	
	public int timeout(){
		return this.timeout;
	}
	
	public Config retry(int retry){
		this.retry = retry;
		return this;
	}
	
	public int retry(){
		return this.retry;
	}
	
	public Config waits(int waits){
		this.waits = waits;
		return this;
	}
	
	public int waits(){
		return this.waits;
	}
	
	public Config threads(int threads){
		this.threads = threads;
		return this;
	}
	
	public int threads(){
		return this.threads;
	}
	
	public Config name(String name){
		this.name = name;
		return this;
	}
	
	public String name(){
		return this.name;
	}
	
	public Config headers(Map<String, String> headers){
		this.headers = headers;
		return this;
	}
	
	public Map<String, String> headers(){
		return this.headers;
	}
	
	public Config header(String key, String value){
		this.headers.put(key, value);
		return this;
	}
	
	public String baseUrl(){
		return this.baseUrl;
	}
	
	public Config baseUrl(String baseUrl){
		this.baseUrl = baseUrl;
		return this;
	}
	
}
