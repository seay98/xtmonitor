package xtmon.domain;

import java.util.Date;

public class Device {

	private int id;
	
	private String name;
	
	private String ip;
	
	private String ident;
	
	private String type;
	
	private String location;
	
	private String switcher;
	
	private Date lmtime;
	
	private Date savetime;
	
	private int state;
	
	private int statusid;
	
	private String sysname;
	
	private String status;
	
	private int alarmid;
	
	private String alarm;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSwitcher() {
		return switcher;
	}

	public void setSwitcher(String switcher) {
		this.switcher = switcher;
	}

	public Date getLmtime() {
		return lmtime;
	}

	public void setLmtime(Date lmtime) {
		this.lmtime = lmtime;
	}

	public Date getSavetime() {
		return savetime;
	}

	public void setSavetime(Date savetime) {
		this.savetime = savetime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAlarmid() {
		return alarmid;
	}

	public void setAlarmid(int alarmid) {
		this.alarmid = alarmid;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

}
