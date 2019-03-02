package com.instamina.thinkify.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.instamina.thinkify.base.dao.LabelDao;
import com.instamina.thinkify.base.entity.Label;
import com.instamina.thinkify.base.service.LabelService;

/**
 * @author INstamina
 * @date 2018年12月22日
 * @description 
 */
@Service
@Transactional
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelDao labelDao;
	
	@Override
	public List<Label> findAll() {
		
		return labelDao.findAll();
	}

	@Override
	public Label findById(String labelId) {
		
		return labelDao.findById(labelId).get();
	}

	@Override
	public void save(Label label) {
		labelDao.save(label);

	}

	@Override
	public void update(Label label) {
		labelDao.save(label);

	}

	@Override
	public void delete(String labelId) {
		labelDao.deleteById(labelId);
	}

	@Override
	public List<Label> findSearch(Label label) {
		return labelDao.findAll(new Specification<Label>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> preList = new ArrayList<>();
				if (label.getLabelname()!=null && !"".equals(label.getLabelname())) {
					Predicate pre = criteriaBuilder.like(root.get("labelname"), "%"+label.getLabelname()+"%");
					preList.add(pre);
				}
				if (label.getState()!=null && !"".equals(label.getState())) {
					Predicate pre = criteriaBuilder.equal(root.get("state"),label.getState());
					preList.add(pre);
				}
				Predicate[] parr = new Predicate[preList.size()]; 
				preList.toArray(parr);
				return criteriaBuilder.and(parr);
			}
			
		});
	}

	@Override
	public Page<Label> pageQuery(Label label, int page, int size) {
		Pageable pageable = PageRequest.of(page-1, size);
		return labelDao.findAll(new Specification<Label>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> pList = new ArrayList<>();
				if (label.getLabelname()!=null && !"".equals(label.getLabelname())) {
					Predicate like = criteriaBuilder.like(root.get("labelname"), "%"+label.getLabelname()+"%");
					pList.add(like);
				}
				if (label.getState()!=null && !"".equals(label.getState())) {
					Predicate equal = criteriaBuilder.equal(root.get("state"),label.getState());
					pList.add(equal);
				}
				Predicate[] parr = new Predicate[pList.size()];
				pList.toArray(parr);
 				return criteriaBuilder.and(parr);
			}
		}, pageable );
	}

}
