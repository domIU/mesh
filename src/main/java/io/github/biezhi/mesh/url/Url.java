package io.github.biezhi.mesh.url;

public class Url {

	private String link;
	private UrlState state;
	
	public Url(String link) {
		this.link = link;
		this.state = UrlState.WAITING;
	}
	
	public String link(){
		return this.link;
	}
	
	public UrlState state(){
		return this.state;
	}
	
	@Override
	public boolean equals(Object obj) {
		Url u = (Url) obj;
		return this.link.equals(u.link) && this.state.equals(u.state);
	}
	
	@Override
	public String toString() {
		return "Url [ link='" + this.link + "', state='" + this.state + "' ]";
	}
}
