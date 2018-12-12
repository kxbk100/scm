package com.scm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class TransactionalConfig {
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory localContainerEntityManagerFactoryBean){
        JpaTransactionManager txManager=new JpaTransactionManager();
        txManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean);
        return txManager;
    }
}
