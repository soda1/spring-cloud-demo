package com.eric.study.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author eric
 * @date 4/4/2023
 */
@RestController
@RefreshScope  //配置动态刷新
@RequestMapping("/properties")
public class PropertiesController {
  @Value("${mysql.username}")
  private String username;

  @Value("${mysql.password}")
  private String password;

  @Value("${mysql.url}")
  private String url;

  @GetMapping("/username")
  public String getUsername(){
    return this.username;
  }

  @GetMapping("/password")
  public String getPassword(){
    return this.password;
  }
  @GetMapping("/url")
  public String getUrl(){
    return this.url;
  }
}
