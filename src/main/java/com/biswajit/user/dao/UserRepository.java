package com.biswajit.user.dao;

import com.biswajit.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

  User findByUsername(String username);
  User findByEmail(String email);

}
