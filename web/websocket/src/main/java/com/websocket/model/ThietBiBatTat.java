package com.websocket.model;

import java.sql.Time;

public class ThietBiBatTat {
	private Long id;
	private String ten;
	private Boolean trangthai;
	private Boolean chedo;
	private Time thoigianmo;
	private Time thoigiantat;
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
	public boolean isTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	public boolean isChedo() {
		return chedo;
	}
	public void setChedo(boolean chedo) {
		this.chedo = chedo;
	}
	public Time getThoigianmo() {
		return thoigianmo;
	}
	public void setThoigianmo(Time thoigianmo) {
		this.thoigianmo = thoigianmo;
	}
	public Time getThoigiantat() {
		return thoigiantat;
	}
	public void setThoigiantat(Time thoigiantat) {
		this.thoigiantat = thoigiantat;
	}
	public ThietBiBatTat(long id, String ten, boolean trangthai, boolean chedo, Time thoigianmo, Time thoigiantat) {
		this.id = id;
		this.ten = ten;
		this.trangthai = trangthai;
		this.chedo = chedo;
		this.thoigianmo = thoigianmo;
		this.thoigiantat = thoigiantat;
	}
	public ThietBiBatTat() {
	}
	@Override
	public String toString() {
		return this.ten + "-"+ this.getThoigianmo() + "-"+this.getThoigiantat();
	}
}
