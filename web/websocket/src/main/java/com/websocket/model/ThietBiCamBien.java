package com.websocket.model;

public class ThietBiCamBien {
	private Long id;
	private String ten;
	private Integer giatri;
	private Integer thoigiandoc;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getGiatri() {
		return giatri;
	}
	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}
	public int getThoigiandoc() {
		return thoigiandoc;
	}
	public void setThoigiandoc(int thoigiandoc) {
		this.thoigiandoc = thoigiandoc;
	}
	public ThietBiCamBien(long id, String ten, int giatri, int thoigiandoc) {
		this.id = id;
		this.ten = ten;
		this.giatri = giatri;
		this.thoigiandoc = thoigiandoc;
	}
	public ThietBiCamBien() {
	}
	
	
}
