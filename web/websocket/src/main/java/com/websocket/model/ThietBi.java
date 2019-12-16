package com.websocket.model;

import java.sql.Time;
public class ThietBi {
	private Long id;
	private String ten;
	private Integer giatri;
	private Integer thoigiandoc;
	private Boolean trangthai;
	private Boolean chedo;
	private Time thoigianmo;
	private Time thoigiantat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Integer getGiatri() {
		return giatri;
	}

	public void setGiatri(Integer giatri) {
		this.giatri = giatri;
	}

	public Integer getThoigiandoc() {
		return thoigiandoc;
	}

	public void setThoigiandoc(Integer thoigiandoc) {
		this.thoigiandoc = thoigiandoc;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public Boolean getChedo() {
		return chedo;
	}

	public void setChedo(Boolean chedo) {
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

	public ThietBi() {
	}

}
