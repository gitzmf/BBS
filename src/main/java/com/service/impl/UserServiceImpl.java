package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserMapper userMapper;

	@Override
	@Cacheable(value="common",key="'users_'+#user.getUserid()")
	public List<User> getUser(User user) throws Exception{
		return userMapper.selectByUser(user);
	}
	
	@Override
	@Cacheable(value="common",key="'users_'+#user.getName()")
	public List<User> getUserName(User user) throws Exception{
		return userMapper.selectByUserName(user);
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void setUser(User user) throws Exception{
		userMapper.insert(user);
	}
	
	@Override
	@Cacheable(value="common",key="'users'")
	public List<User> getUser() throws Exception{
		return userMapper.selectByUserAll();
	}
	
	@Override
	@Cacheable(value="common",key="'userids_'+#userid")
	public List<User> getUserId(int userid) throws Exception{	
		return userMapper.selectByUserId(userid);
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void updateUser(User user) throws Exception{	
		userMapper.updateByPrimaryKey(user);
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void deleteUser(User user) throws Exception{
		userMapper.deleteByPrimaryKey(user.getUserid());
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void updateUserSetup(User user) throws Exception{
		userMapper.updateSetupByPrimaryKey(user);
	}
	
	@Override
	@Cacheable(value="common",key="'userKey_'+#userid")
	public User getUserKey(int userid) throws Exception{	
		return userMapper.selectByPrimaryKey(userid);
	}	
}
