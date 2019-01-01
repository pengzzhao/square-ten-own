package com.tensquare.search.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author pengzhao
 * @Title: Article
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/117:04
 */
@Getter
@Setter
@Document(indexName = "tensquare_article", type = "article")
public class Article implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 标题
     */
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;

    /**
     * 文章正文
     */
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    /**
     * 审核状态
     */
    private String state;
}
