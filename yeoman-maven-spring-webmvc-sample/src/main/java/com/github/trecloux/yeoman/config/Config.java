package com.github.trecloux.yeoman.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.github.trecloux.yeoman.rest")
@EnableWebMvc
public class Config {
}
