package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.mapper.ArticleMapper;
import com.pojo.Article;
import com.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	@CacheEvict(value="common", allEntries = true)
	public void setArticle(Article article) throws Exception{
		articleMapper.insert(article);
	}

	@Override
	@Cacheable(value="common",key="'articles'")
	public List<Article> getArticle() throws Exception{	
		return articleMapper.selectByArticle();
	}

	@Override
	@Cacheable(value="common",key="#articleTitle")
	public List<Article> getArticleTitle(String articleTitle) throws Exception{	
		 List<Article> articles = articleMapper.selectByArticleTitle(articleTitle);
		return articles;
	}

	@Override
	@Cacheable(value="common",key="'articles_'+#bname")
	public List<Article> getArticleBname(String bname) throws Exception{
		return articleMapper.selectByArticleBname(bname);
	}

	@Override
	@Cacheable(value="common",key="'articles_'+#userid")
	public List<Article> getArticleId(int userid) throws Exception{	
		return articleMapper.selectByArticleId(userid);
	}

	@Override
	@Cacheable(value="common",key="'articles_'+#fid")
	public Article getArticleKey(int fid) throws Exception{		
		return articleMapper.selectByPrimaryKey(fid);
	}

	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteArticle(int fid) throws Exception{
		articleMapper.deleteByPrimaryKey(fid);
	}

	@Override
	@CacheEvict(value="common", allEntries = true)
	public void updateArticle(Article article) throws Exception{		
		articleMapper.updateByPrimaryKey(article);
	}

	@Override
	@CacheEvict(value="common", allEntries = true)
	public void updateArticleStatus(Article article) throws Exception {		
		articleMapper.updateArticleStatus(article);
	}

	@Override
	@CacheEvict(value="common", allEntries = true)
	public void deleteArticleUserid(int userid) throws Exception{		
		articleMapper.deleteByUserid(userid);
	}

	@Override
	@CacheEvict(value="common", allEntries = true)
	public void updateArticleSetup(Article article) throws Exception{	
		articleMapper.updateArticleSetup(article);
	}

}
