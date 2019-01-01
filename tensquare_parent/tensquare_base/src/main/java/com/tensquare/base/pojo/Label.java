package com.tensquare.base.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author pengzhao
 * @Title: Label
 * @ProjectName tensquare_parent
 * @Description: 标签实体类
 * @date 2019/1/1 17:04
 */
@Getter
@Setter
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

    @Id
    private String id;
    /**
     * 标签名称
     */
    private String labelname;
    /**
     * 状态
     */
    private String state;
    /**
     * 使用数量
     */
    private Long count;
    /**
     * 关注数
     */
    private Long fans;
    /**
     * 是否推荐
     */
    private String recommend;

}
