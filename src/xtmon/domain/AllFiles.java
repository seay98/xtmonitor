package xtmon.domain;

import java.util.Date;

public class AllFiles {
	
	private String sysname;
	
	private String sysalias;
	
	private int count;
	
	private Date ltime;
	
	private long span;

	public Date getLtime() {
		return ltime;
	}

	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}

	public long getSpan() {
		return span;
	}

	public void setSpan(long span) {
		this.span = span;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getSysalias() {
		return sysalias;
	}

	public void setSysalias(String sysalias) {
		this.sysalias = sysalias;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
