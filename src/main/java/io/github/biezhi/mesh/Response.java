package io.github.biezhi.mesh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Response {

	private int code;
	
	private Config config;
	private String html;
	private FileItem fileItem;
	
	public Response(Config config, int code) {
		this.config = config;
		this.code = code;
	}
	
	public int code(){
		return this.code;
	}
	
	public Config config(){
		return this.config;
	}
	
	public String html(){
		return this.html;
	}
	
	public Response html(String html){
		this.html = html;
		return this;
	}
	
	public Document doc() {
		return Jsoup.parse(html);
	}
	
	public Elements doc(String selector) {
		return doc().select(selector);
	}

	public Response fileItem(byte[] data, int length, String fileName) {
		this.fileItem = new FileItem(data, length, fileName);
		return this;
	}
	
	public FileItem fileItem() {
		return this.fileItem;
	}
	
	class FileItem {
		byte[] data;
		String fileName;
		int length;
		
		public FileItem(byte[] data, int length, String fileName) {
			this.data = data;
			this.length = length;
			this.fileName = fileName;
		}
		
		public byte[] data(){
			return this.data;
		}
		
		public int length(){
			return this.length;
		}
		
		public String fileName(){
			return this.fileName;
		}
	}
	
}
