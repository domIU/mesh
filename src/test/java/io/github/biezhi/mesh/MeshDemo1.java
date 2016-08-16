package io.github.biezhi.mesh;

import io.github.biezhi.mesh.Mesh;
import io.github.biezhi.mesh.Response;
import io.github.biezhi.mesh.spider.AbsSpider;

/**
 * 最简单的一个例子
 * @author Administrator
 *
 */
public class MeshDemo1 extends AbsSpider {
	
	@Override
	public void parse(Response response) {
		System.out.println(response.html());
	}
	
	public static void main(String[] args) {
		Mesh.lets(new MeshDemo1(), "http://www.baidu.com").go();
	}
	
	
}
