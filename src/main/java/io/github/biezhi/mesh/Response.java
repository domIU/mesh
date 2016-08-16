package io.github.biezhi.mesh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Response {

	private String html;
	
	public Response(String html) {
		this.html = html;
	}
	
	public String html(){
		return this.html;
	}
	
	public Document doc() {
		return Jsoup.parse(html);
	}
	
	public Elements doc(String selector) {
		return doc().select(selector);
	}
}
