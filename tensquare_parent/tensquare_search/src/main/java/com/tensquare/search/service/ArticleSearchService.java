package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @author pengzhao
 * @Title: ArticleSearchService
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/117:18
 */
@Service
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

    @Autowired
    private IdWorker idWorker;
    /**
     * 增加文章
     * @param article 文章
     */
    public void save(Article article){
        //article.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }

    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(key, key, pageable);
    }
}
