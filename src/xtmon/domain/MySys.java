package xtmon.domain;

import java.util.Date;

public class MySys {
	
	private int id;
	
	private String name;
	
	private String alias;
	
	private int state;
	
	private Date statetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getStatetime() {
		return statetime;
	}

	public void setStatetime(Date statetime) {
		this.statetime = statetime;
	}

}
