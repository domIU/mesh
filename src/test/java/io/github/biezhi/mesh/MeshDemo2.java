package io.github.biezhi.mesh;

import io.github.biezhi.mesh.Config;
import io.github.biezhi.mesh.Mesh;
import io.github.biezhi.mesh.Response;
import io.github.biezhi.mesh.spider.AbsSpider;

/**
 * 试试配置一个header
 * @author Administrator
 *
 */
public class MeshDemo2 extends AbsSpider {
	
	@Override
	public void parse(Response response) {
		System.out.println(response.html());
	}
	
	@Override
	public Config config() {
		return Config.get().header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0");
	}
	
	public static void main(String[] args) {
		Mesh.lets(new MeshDemo2(), "https://biezhi.me").go();
	}
	
}
