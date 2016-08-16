package io.github.biezhi.mesh;

import java.util.Iterator;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.biezhi.mesh.Config;
import io.github.biezhi.mesh.Mesh;
import io.github.biezhi.mesh.Response;
import io.github.biezhi.mesh.spider.AbsSpider;

/**
 * 抓取知乎推荐里的标题
 */
public class MeshDemo3 extends AbsSpider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MeshDemo3.class);
	
	@Override
	public Config config() {
		return Config.get("zhihu");
	}
	
	@Override
	public void parse(Response response) {
		Iterator<Element> its = response.doc("a.post-link").iterator();
		while(its.hasNext()){
			LOGGER.info("(´･_･`) " + its.next().text());
		}
	}
	
	public static void main(String[] args) {
		Mesh.lets("https://www.zhihu.com/explore/recommendations", new MeshDemo3()).go();
	}
	
}
