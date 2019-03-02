package com.instamina.thinkify.base.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import entity.Result;
import entity.StatusCode;

/**
 * @author INstamina
 * @date 2018年12月22日
 * @description 
 */
@RestControllerAdvice
public class BaseExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public Result error(Exception e) {
		e.printStackTrace();
		return new Result(false,StatusCode.ERROR,e.getMessage());
	}
}
