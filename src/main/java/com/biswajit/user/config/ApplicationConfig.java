package com.biswajit.user.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.biswajit.user.dao")
@EntityScan(basePackages = "com.biswajit.user.domain")
@EnableTransactionManagement
public class ApplicationConfig {

}
