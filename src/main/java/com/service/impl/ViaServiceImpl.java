package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.mapper.ViaMapper;
import com.pojo.Via;
import com.service.IViaService;

@Service
public class ViaServiceImpl implements IViaService{

	@Autowired
	ViaMapper viaMapper;
	
	@Override
	@Cacheable(value="common",key="'vias_'+#userid")
	public Via getVia(int userid) throws Exception{
		return viaMapper.selectByPrimaryKey(userid);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void setUserPhoto(Via via) throws Exception{
		viaMapper.insert(via);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void updateVia(Via via) throws Exception{	
		viaMapper.updateByPrimaryKey(via);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteVia(Integer userid) throws Exception{	
		viaMapper.deleteByPrimaryKey(userid);
	}

}
