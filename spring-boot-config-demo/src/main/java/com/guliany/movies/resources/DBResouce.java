package com.guliany.movies.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guliany.movies.config.DBSetting;

@RestController
@RefreshScope
public class DBResouce {

	@Autowired
	private DBSetting dbSetting;
	
	@Autowired
	private Environment env;

	@GetMapping("/")
	public String message() {
		return dbSetting.toString();
	}
	
	@GetMapping("/envDetails")
	public String getEnvDetails() {
		return env.toString();
	}

}
