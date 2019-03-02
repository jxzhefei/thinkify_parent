package com.instamina.thinkify.base.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.instamina.thinkify.base.entity.Label;

/**
 * @author INstamina
 * @date 2018年12月22日
 * @description 
 */
public interface LabelService {
	List<Label> findAll();
	Label findById(String labelId);
	void save(Label label);
	void update(Label label);
	void delete(String labelId);
	List<Label> findSearch(Label label);
	Page<Label> pageQuery(Label label, int page, int size);
}
