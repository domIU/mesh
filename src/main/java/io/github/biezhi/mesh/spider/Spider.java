package io.github.biezhi.mesh.spider;

import java.util.Collection;

import io.github.biezhi.mesh.Config;
import io.github.biezhi.mesh.Response;

/**
 * 爬虫处理接口
 * @author Administrator
 *
 */
public interface Spider {
	
	/**
	 * 配置
	 * @return
	 */
	Config config();
	
	/**
	 * 发现链接
	 */
	Collection<String> discover(Response response, Config config);
	
	/**
	 * 爬虫结果
	 * @param response
	 */
	void parse(Response response);
	
	boolean shutdown();
}
