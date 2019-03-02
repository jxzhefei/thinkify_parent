package com.instamina.thinkify.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instamina.thinkify.base.entity.Label;
import com.instamina.thinkify.base.service.LabelService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import utils.IdWorker;

/**
 * @author INstamina
 * @date 2018年12月22日
 * @description 
 */
@RestController
@RequestMapping(value="/label")
public class LabelController {
	@Autowired
	private LabelService labelService;
	@Autowired
	private IdWorker idWorker;
	@GetMapping
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功！",labelService.findAll());
	}
	@GetMapping(value="/{labelId}")
	public Result findById(@PathVariable String labelId) {
		return new Result(true,StatusCode.SUCCESS,"查询成功！",labelService.findById(labelId));
	}
	@PostMapping
	public Result save(@RequestBody Label label) {
		label.setId(idWorker.nextId()+"");
		labelService.save(label);
		return new Result(true,StatusCode.SUCCESS,"添加成功！");
	}
	@PutMapping(value="/{labelId}")
	public Result update(@PathVariable String labelId,@RequestBody Label label) {
		label.setId(labelId);
		labelService.update(label);
		return new Result(true, StatusCode.SUCCESS, "修改成功！");
	}
	@DeleteMapping(value="/{labelId}")
	public Result delete(@PathVariable String labelId) {
		labelService.delete(labelId);
		return new Result(true, StatusCode.SUCCESS, "删除成功！");
	}
	@PostMapping(value="/search")
	public Result findSearch(@RequestBody Label label) {
		List<Label> list = labelService.findSearch(label);
		return new Result(true,StatusCode.SUCCESS,"查询成功！",list);
	}
	@PostMapping(value="/search/{page}/{size}")
	public Result pageQuery(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
		Page<Label> pageData = labelService.pageQuery(label,page,size);
		return new Result(true,StatusCode.SUCCESS,"查询成功！",new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
	}
}
