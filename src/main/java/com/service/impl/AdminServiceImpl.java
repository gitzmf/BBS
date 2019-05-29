package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.mapper.AdminMapper;
import com.pojo.Admin;
import com.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	AdminMapper adminMapper;

	@Override
	@Cacheable(value="common",key="'id'+#admin.getAid()")
	public List<Admin> getAdmin(Admin admin) throws Exception{
		return adminMapper.selectByAdmin(admin);
	}

	@Override
	@Cacheable(value="common",key="'id'+#admin.getAname()")
	public List<Admin> getAdminName(Admin admin) throws Exception{
		return adminMapper.selectByAdminName(admin);
	}

	@Override
	@CacheEvict(value="common",allEntries=true)
	public void setAdmin(Admin admin) throws Exception{
		adminMapper.insert(admin);
	}
}
