package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author pengzhao
 * @Title: ArticleSearchDao
 * @ProjectName tensquare_parent
 * @Description: 文章数据访问层接口
 * @date 2019/1/117:17
 */

public interface ArticleSearchDao extends ElasticsearchRepository<Article, String> {

    /**
     * 检索
     * @param title 标题
     * @param content 正文
     * @param pageable 分页器
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
