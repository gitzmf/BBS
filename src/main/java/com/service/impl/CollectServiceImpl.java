package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mapper.CollectMapper;
import com.pojo.Collect;
import com.service.ICollectService;

@Service
public class CollectServiceImpl implements ICollectService{

	@Autowired
	CollectMapper collectMapper;
	
	@Override
	@Cacheable(value="common",key="'collects'")
	public List<Collect> getCollect() throws Exception{
		return collectMapper.selectByCollect();
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteCollect(Collect collect) throws Exception{
		collectMapper.deleteByCollect(collect);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void setCollect(Collect collect) throws Exception{
		collectMapper.insert(collect);
	}
	
	@Override
	@Cacheable(value="common",key="'collects_'+#userid")
	public List<Collect> getCollect(int userid) throws Exception{
		return collectMapper.selectByCollectUserid(userid);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteCollectUseridAndFid(Collect collect) throws Exception{
		collectMapper.deleteCollectUseridAndFid(collect);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteCollectFid(int fid)throws Exception {		
		collectMapper.deleteByCollectFid(fid);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteCollectUserid(int userid) throws Exception{	
		collectMapper.deleteCollectUserid(userid);
	}

}
