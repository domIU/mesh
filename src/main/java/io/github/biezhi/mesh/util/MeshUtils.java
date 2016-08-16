package io.github.biezhi.mesh.util;

import java.net.MalformedURLException;
import java.net.URL;

public class MeshUtils {

	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUrl(String urlStr){
		try {
			URL url = new URL(urlStr);
			int port = url.getPort();
			if(port == 80 || port == -1){
				return url.getProtocol() + "://" + url.getHost();
			}
			return url.getProtocol() + "://" + url.getHost() + ":" + port;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return urlStr;
	}
	
	public static String getFileName(String url){
		return url.substring(url.lastIndexOf("/") + 1);
	}
	
}
