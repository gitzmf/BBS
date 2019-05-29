package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mapper.AttentionMapper;
import com.pojo.Attention;
import com.service.IAttentionService;

@Service
public class AttentionServiceImpl implements IAttentionService{

	@Autowired
	AttentionMapper attentionMapper;
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void setAttention(Attention attention) throws Exception{
		attentionMapper.insert(attention);
	}
	
	@Override
	@Cacheable(value="common",key="'attentions'")
	public List<Attention> getAttention() throws Exception{
		return attentionMapper.selectByAttention();
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteAttention(Attention attention) throws Exception{
		attentionMapper.deleteByAttention(attention);
	}
		
	@Override
	@Cacheable(value="common",key="'attentions_'+#userid")
	public List<Attention> getAttention(int userid) throws Exception{	
		return attentionMapper.selectByUserid(userid);
	}
	
	@Override
	@Cacheable(value="common",key="'attentionBes_'+#beuserid")
	public List<Attention> getAttentionBe(int beuserid) throws Exception{	
		return attentionMapper.selectByBeuserid(beuserid);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteAttentionMyself(Attention attention) throws Exception{	
		attentionMapper.deleteByAttentionMyself(attention);
	}
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteAttentionUseridOrBeuserid(int userid) throws Exception{
		attentionMapper.deleteAttentionUseridOrBeuserid(userid);
	}
}
