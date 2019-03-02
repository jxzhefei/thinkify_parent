package com.instamina.thinkify.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.instamina.thinkify.base.entity.Label;

/**
 * @author INstamina
 * @date 2018年12月22日
 * @description 
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

}
