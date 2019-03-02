package com.instamina.thinkify.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import utils.IdWorker;

/**
 * @author INstamina
 * @date 2018年12月11日
 * @description 
 */
@SpringBootApplication
public class BaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}
	@Bean
	public IdWorker getIdWorker() {
		return new IdWorker();
	}
}
