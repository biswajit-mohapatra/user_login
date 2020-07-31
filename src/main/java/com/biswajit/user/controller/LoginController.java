package com.biswajit.user.controller;

import com.biswajit.user.domain.User;
import com.biswajit.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping(value = {"/", "/login"})
  public String login() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String loginPost(
      @RequestParam("username") String username, @RequestParam("password") String password) {
    log.info("Inside Here ");
    User user = userService.getUserByUsernameAndPassword(username, password);
    log.info("Logged in user details : {}",user);
     /*

      */
    return "login";
  }
}
