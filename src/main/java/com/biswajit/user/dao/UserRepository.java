package com.biswajit.user.dao;

import com.biswajit.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

  User findByUsername(String username);
  User findByEmail(String email);
  User findByUsernameAndPassword(@RequestParam String username,@RequestParam String password);
}
