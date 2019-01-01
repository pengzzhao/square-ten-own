package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void save(Label label){
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，也就是要把条件封装到哪个对象中，where 类名=label.getid
             * @param criteriaQuery 封装的都是查询关键字，比如group by order by等
             * @param criteriaBuilder 用来封装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //list集合，存放所有的条件
                List<Predicate> list = new ArrayList<>();

                if (StringUtils.isNotEmpty(label.getLabelname())){
                    list.add(criteriaBuilder.like(root.get("labelname"), "%" + label.getLabelname() + "%"));
                }
                if (StringUtils.isNotEmpty(label.getState())){
                    list.add(criteriaBuilder.equal(root.get("state").as(String.class), label.getState()));
                }

                Predicate[]  predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        });
    }

    public Page<Label> pageQuery(Label label, int page, int size) {

        //封装分页对象
        Pageable pageable = PageRequest.of(page - 1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，也就是要把条件封装到哪个对象中，where 类名=label.getid
             * @param criteriaQuery 封装的都是查询关键字，比如group by order by等
             * @param criteriaBuilder 用来封装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //list集合，存放所有的条件
                List<Predicate> list = new ArrayList<>();

                if (StringUtils.isNotEmpty(label.getLabelname())){
                    list.add(criteriaBuilder.like(root.get("labelname"), "%" + label.getLabelname() + "%"));
                }
                if (StringUtils.isNotEmpty(label.getState())){
                    list.add(criteriaBuilder.equal(root.get("state").as(String.class), label.getState()));
                }

                Predicate[]  predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        }, pageable);
    }
}
