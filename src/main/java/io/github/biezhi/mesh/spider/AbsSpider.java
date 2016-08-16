package io.github.biezhi.mesh.spider;

import java.util.Collection;

import io.github.biezhi.mesh.Config;
import io.github.biezhi.mesh.Response;

public abstract class AbsSpider implements Spider {
	
	@Override
	public Config config() {
		return null;
	}
	
	@Override
	public Collection<String> discover(Response response, Config config) {
		return null;
	}
	
	@Override
	public boolean shutdown() {
		return false;
	}
	
}
