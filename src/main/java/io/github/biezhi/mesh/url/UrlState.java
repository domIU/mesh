package io.github.biezhi.mesh.url;

public enum UrlState {
	
	WAITING("等待执行"),EXECUTION("执行中"),FINISH("执行完毕");
	
	String desc;
	
	UrlState(String desc){
		this.desc = desc;
	}
	
	public String desc(){
		return this.desc;
	}
}
