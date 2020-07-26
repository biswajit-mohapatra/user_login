package com.biswajit.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
@GetMapping("health/status")
  public String status(){
    return "GREEN";
  }

}
