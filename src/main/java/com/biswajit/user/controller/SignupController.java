package com.biswajit.user.controller;

import com.biswajit.user.domain.User;
import com.biswajit.user.model.UserModel;
import com.biswajit.user.service.UserService;
import com.biswajit.user.util.UserUtils;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller

public class SignupController {

  private static final String SIGN_UP_URL_MAPPING = "/signup";
  private static final String SIGN_UP_VIEW_NAME = "registration";

  private static final String DUPLICATED_USERNAME_KEY = "duplicatedUsername";
  private static final String DUPLICATED_EMAIL_KEY = "duplicatedEmail";

  private static final String SIGNED_UP_MESSAGE_KEY = "signedUp";
  public static final String ERROR_MESSAGE_KEY = "message";

  @Autowired
  private UserService userService;

  @GetMapping(value=SIGN_UP_URL_MAPPING)
  public String signUpGet() {
    return SIGN_UP_VIEW_NAME;
  }

  @PostMapping(value=SIGN_UP_URL_MAPPING)
  public String signUpPost(@ModelAttribute("userModel") @Valid UserModel userModel, ModelMap model) {
    log.info("User model : {}",userModel);
    this.checkForDuplicates(userModel,model);

    boolean isDuplicate = false;
    List<String> errorMessages = new ArrayList<>();

    if(model.containsKey(DUPLICATED_USERNAME_KEY)){
     log.warn("The Username already exists.Displaying error to the user");
     model.addAttribute(SIGNED_UP_MESSAGE_KEY,"false");
     errorMessages.add("Username already exists");
     isDuplicate = true;
    }

    if(model.containsKey(DUPLICATED_EMAIL_KEY)){
      log.warn("The Email already exists.Displaying error to the user");
      model.addAttribute(SIGNED_UP_MESSAGE_KEY,"false");
      errorMessages.add("Email already exists");
      isDuplicate = true;
    }

    if(isDuplicate){
      model.addAttribute(ERROR_MESSAGE_KEY,errorMessages);
      return SIGN_UP_VIEW_NAME;
    }

    log.info("Transforming user payload into User domain object");
    User user = UserUtils.fromWebUserToDomainUser(userModel);

    userService.saveUser(user);
    log.info("User created successfully");
    model.addAttribute(SIGNED_UP_MESSAGE_KEY, "true");
    git stat
    return SIGN_UP_VIEW_NAME;
  }

  private void checkForDuplicates(UserModel userModel,ModelMap model){

    if(userService.getUserByName(userModel.getUserName()) != null){
      model.addAttribute(DUPLICATED_USERNAME_KEY,true);
    }

    if(userService.getUserByEmail(userModel.getEmail()) != null){
      model.addAttribute(DUPLICATED_EMAIL_KEY,true);
    }

  }

  @ModelAttribute("userModel")
  public UserModel getUserModel(){
    return new UserModel();
  }
}
