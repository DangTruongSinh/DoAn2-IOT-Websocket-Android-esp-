package com.websocket.service;

import java.util.List;

import com.websocket.model.ThietBi;

public interface IThietBiService {
	public List<ThietBi> getAll();
	public ThietBi update(ThietBi object);
	public List<ThietBi> updateMod(ThietBi object);
}
