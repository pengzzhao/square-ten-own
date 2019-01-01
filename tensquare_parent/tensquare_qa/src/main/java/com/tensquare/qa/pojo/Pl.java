package com.tensquare.qa.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author pengzhao
 * @Title: Pl
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/121:57
 */
@Getter
@Setter
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {
    @Id
    private String problemid;
    @Id
    private String lableid;
}
