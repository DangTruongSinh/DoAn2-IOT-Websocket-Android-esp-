package com.websocket.model;

public class ThietBi {
	private String name;
	private boolean status;
	private String nhietdo;
	public ThietBi()
	{
		
	}
	public ThietBi(String name, String nhietdo) {
		super();
		this.name = name;
		this.nhietdo = nhietdo;
	}
	public ThietBi(String name, boolean status) {
		super();
		this.name = name;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getNhietdo() {
		return nhietdo;
	}
	public void setNhietdo(String nhietdo) {
		this.nhietdo = nhietdo;
	}
	
	
}
