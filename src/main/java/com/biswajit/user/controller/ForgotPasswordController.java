package com.biswajit.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("forgot-password")
public class ForgotPasswordController {

  @GetMapping
  public String forgotPassword() {
    return "emailForm";
  }
}
