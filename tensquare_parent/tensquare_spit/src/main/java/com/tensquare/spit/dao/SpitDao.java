package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author pengzhao
 * @Title: SpitDao
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/20:07
 */
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 根据父ID查询
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);

}
