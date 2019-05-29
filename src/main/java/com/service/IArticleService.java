package com.service;

import java.util.List;

import com.pojo.Article;

/**
 * @author cll
 * @version 1.0
 * @ClassName IArticleService
 * @Description: TODO: 文章功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface IArticleService {

    /**
    　* @Description: TODO: 向数据库插入发帖信息
    　* @param 封装的文章article对象
    　* @return  返回的封装article对象的集合
    　* @throws
    　* @author cll
    　* @date 2019/5/26 23:20
    　*/
    void setArticle(Article article) throws Exception;

    /**
     　* @Description: TODO: 按帖子标题模糊查询（搜索框搜索）
     　* @param   查询的标题articleTitle
     　* @return  返回的封装article对象的集合
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    List<Article> getArticleTitle(String articleTitle) throws Exception;

    /**
     　* @Description: TODO: 按帖子板块查询出帖子
     　* @param   查询的板块名bname
     　* @return  返回的封装article对象的集合
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    List<Article> getArticleBname(String bname) throws Exception;

    /**
     　* @Description: TODO: 按userid查询发帖表信息
     　* @param   查询的用户
     　* @return  返回的封装article对象的集合
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    List<Article> getArticleId(int userid) throws Exception;


    /**
     　* @Description: TODO: 按fid查询发帖表信息
     　* @param   查询的fid
     　* @return  返回的封装article对象
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    Article getArticleKey(int fid) throws Exception;

    /**
     　* @Description: TODO: 按fid删除帖子
     　* @param   删除的fid
     　* @return
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    void deleteArticle(int fid) throws Exception;

    /**
     　* @Description: TODO: 修改帖子表
     　* @param   删除的fid
     　* @return
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    void updateArticle(Article article) throws Exception;

    /**
     　* @Description: TODO: 修改article表的status属性（修改审核状态）
     　* @param   删除的fid
     　* @return
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    void updateArticleStatus(Article article) throws Exception;

    /**
     　* @Description: TODO: 删除用户对应的帖子信息(按userid)
     　* @param   删除的userid
     　* @return
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    void deleteArticleUserid(int userid) throws Exception;

    /**
     　* @Description: TODO: 修改article表中的username
     　* @param   封装的文章article对象
     　* @return
     　* @throws
     　* @author cll
     　* @date 2019/5/26 23:20
     　*/
    void updateArticleSetup(Article article) throws Exception;
    
    /**
   　* @Description: TODO: 查询文章
   　* @param    
   　* @return 封装的Article对象集合
   　* @throws
   　* @author cll
   　* @date 2019/5/26 23:20
   　*/
	List<Article> getArticle() throws Exception;

 
}
