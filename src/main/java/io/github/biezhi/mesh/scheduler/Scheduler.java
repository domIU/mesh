package io.github.biezhi.mesh.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blade.kit.DateKit;
import io.github.biezhi.mesh.Config;
import io.github.biezhi.mesh.spider.Spider;
import io.github.biezhi.mesh.url.Url;
import io.github.biezhi.mesh.url.UrlManager;

/**
 * 调度器
 * @author Administrator
 *
 */
public class Scheduler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);
	
	private Spider spider;
	private static ExecutorService pool;
	private static long timestmp;
	private Config config;
	
	public Scheduler(String baseUrl, Spider spider) {
		this.spider = spider;
		this.config = spider.config();
		if(null == this.config){
			this.config = Config.get();
		}
		this.init(baseUrl);
	}
	
	private void init(String baseUrl){
		UrlManager.push(baseUrl);
		this.config.baseUrl(baseUrl);
		int threads = this.config.threads();
		pool = Executors.newFixedThreadPool(threads);
		timestmp = DateKit.getCurrentUnixTime();
	}
	
	/**
	 * 开始跑起来吧 :)
	 */
	public void go() {
		// 只要有url
		while(!UrlManager.isEmpty()){
			if(spider.shutdown()){
				shutdown();
				break;
			}
			Url url = UrlManager.pop();
			Runnable t = new WorkerNode(this.spider, this.config, url);
			pool.execute(t);
			sleep(null, 100);
		}
		this.waitShutdown();
	}
	
	/**
	 * 等待任务执行并停止线程池
	 */
	private void waitShutdown(){
		
        LOGGER.debug("(-_-#) Task start wait...");
        
		// wait and shutdown
        sleep(null, 1000);
		int wait = this.config.waits();
		
		boolean isShutdown = true;
		
		while(wait > 0){
			sleep(null, 1000);
			// 如果有URL要抓取
			if(!UrlManager.isEmpty()){
				wait = this.config.waits();
				isShutdown = false;
				LOGGER.debug("Task reactived...");
				this.go();
				break;
			}
			wait--;
		}
		
		if(isShutdown){
			shutdown();
		}
			
	}
	
	private void sleep(Thread thread, int m){
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public static void shutdown(){
		if(!pool.isShutdown()){
			long seconds = (DateKit.getCurrentUnixTime() - timestmp);
			pool.shutdown();
			LOGGER.info("(-_-#) Spider running {} seconds!", seconds);
			LOGGER.debug("(-_-#) Task shutdown!");
			System.exit(0);
		}
	}
}
