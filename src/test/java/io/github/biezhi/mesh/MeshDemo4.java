package io.github.biezhi.mesh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.biezhi.mesh.scheduler.Scheduler;
import io.github.biezhi.mesh.spider.AbsSpider;

/**
 * 抓取豆瓣top100的电影名称
 */
public class MeshDemo4 extends AbsSpider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MeshDemo4.class);
	
	private int count = 1;
	
	@Override
	public Config config() {
		return Config.get("douban").threads(5);
	}
	
	@Override
	public void parse(Response response) {
		Iterator<Element> its = response.doc("div.article div.hd a span.title:eq(0)").iterator();
		while(its.hasNext()){
			if(count > 100){
				Scheduler.shutdown();
			} else{
				LOGGER.info(count + ". " + its.next().text());
			}
			count++;
		}
	}
	
	@Override
	public Collection<String> discover(Response response) {
		List<String> urls = new ArrayList<String>();
		Iterator<Element> its = response.doc("div.paginator a").iterator();
		String baseUrl = "https://movie.douban.com/top250";
		while(its.hasNext()){
			String url = baseUrl + its.next().attr("href");
			urls.add(url);
		}
		return urls;
	}
	
	public static void main(String[] args) {
		Mesh.lets(new MeshDemo4(), "https://movie.douban.com/top250?start=0&filter=").go();
	}
	
	
}
