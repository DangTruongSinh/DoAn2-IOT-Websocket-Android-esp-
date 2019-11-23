package com.websocket.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.websocket.model.ThietBi;
import com.websocket.model.ThietBiBatTat;
import com.websocket.model.ThietBiCamBien;
import com.websocket.respository.impl.TBBatTatRespository;
import com.websocket.respository.impl.TBCamBienRespository;

public class ThietBiService implements IThietBiService {
	TBBatTatRespository tbBatTatRespository;
	TBCamBienRespository tbCamBienRespository;
	ModelMapper mapper;
	public ThietBiService() {
		tbBatTatRespository = new TBBatTatRespository();
		tbCamBienRespository = new TBCamBienRespository();
		mapper = new ModelMapper();
	}
	@Override
	public List<ThietBi> getAll() {
		List<ThietBi> listResult = new ArrayList<ThietBi>();
		tbBatTatRespository.findAll().forEach((item) -> listResult.add(mapper.map(item,ThietBi.class)));
		tbCamBienRespository.findAll().forEach((item) -> listResult.add(mapper.map(item,ThietBi.class)));
	return listResult;
	}
	@Override
	public ThietBi update(ThietBi object) {
		if(object.getTen().contains("cb"))
			return mapper.map(tbCamBienRespository.update(mapper.map(object,ThietBiCamBien.class)),ThietBi.class);
		else
			return mapper.map(tbBatTatRespository.update(mapper.map(object,ThietBiBatTat.class)),ThietBi.class);
	}
	@Override
	public List<ThietBi> updateMod(ThietBi object) {
		List<ThietBi> listResult = new ArrayList<ThietBi>();
		tbBatTatRespository.updateMode(object.getChedo(), object.getThoigianmo(),
				object.getThoigiantat()).forEach((item)->listResult.add(mapper.map(item,ThietBi.class)));
		return listResult;
	}
}
	