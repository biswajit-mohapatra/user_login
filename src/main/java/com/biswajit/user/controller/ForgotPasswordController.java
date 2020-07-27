package com.biswajit.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("forgot-password")
public class ForgotPasswordController {

 @GetMapping
  public String forgotPassword() {
   return "emailForm";
  }

  @PostMapping
  public String sendEmailLink(@RequestParam(value ="email",required = true) String email) {
   log.info("Sending Email link to :{} ",email);
    return "emailForm";
  }

}
