package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mapper.PlateMapper;
import com.pojo.Plate;
import com.service.IPlateService;

@Service
public class PlateServiceImpl implements IPlateService{

	@Autowired
	PlateMapper plateMapper;

	@Override
	@Cacheable(value="common",key="'plates'")
	public List<Plate> getPlate() throws Exception{		
		return plateMapper.selectAll();
	}

	@Override
	@CacheEvict(value="common",allEntries=true)
	public void setPlate(Plate plate) throws Exception{
		plateMapper.insert(plate);
	}

	@Override
	@Cacheable(value="common",key="'plates_'+#plate.getBname()")
	public List<Plate> getPlateName(Plate plate) throws Exception{
		return plateMapper.selectByAdminName(plate);
	}

	@Override
	@CacheEvict(value="common",allEntries=true)
	public void deletePlate(Plate plate_delete) throws Exception{
		plateMapper.deleteByPrimaryKey(plate_delete.getBid());
	}

	@Override
	@CacheEvict(value="common",allEntries=true)
	public void updatePlate(Plate plate) throws Exception{
		plateMapper.updateByPrimaryKey(plate);
	}
}
