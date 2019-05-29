package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mapper.CommentMapper;
import com.pojo.Comment;
import com.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService{
	
	@Autowired
	CommentMapper commentMapper;
	
	@Override
	@Cacheable(value="common",key="'CommentFid_'+#fid")
	public List<Comment> getCommentFid(int fid) throws Exception{	
		return commentMapper.selectByCommentFid(fid);
	}
	
	@Override
	@Cacheable(value="common",key="'CommentUserid_'+#userid")
	public List<Comment> getCommentUserid(int userid) throws Exception{
		return commentMapper.selectByCommentUserid(userid);
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void setComment(Comment comment) throws Exception{
		commentMapper.insert(comment);
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void deleteComment(int pid) throws Exception{
		commentMapper.deleteByPrimaryKey(pid);
	}
	
	@Override
	@CacheEvict(value="common",allEntries=true)
	public void deleteCommentUserid(int userid) throws Exception{		
		commentMapper.deleteByUserid(userid);
	}
}
