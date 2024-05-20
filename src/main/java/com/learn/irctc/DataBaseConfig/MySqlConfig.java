package com.learn.irctc.DataBaseConfig;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.learn.irctc.Repo", entityManagerFactoryRef = "mysqlEntityManager", transactionManagerRef = "mysqlTransactionManager")
public class MySqlConfig {
//	@Primary
//	@Bean(name = "mysqlDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.mysql")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Primary
//	@Bean(name = "mysqlEntityManager")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setDataSource(dataSource());
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("com.learn.irctc.entities");
//		return factory;
//	}
//
//	@Primary
//	@Bean(name = "mysqlTransactionManager")
//	public PlatformTransactionManager transactionManager() {
//		EntityManagerFactory factory = entityManagerFactory().getObject();
//		return new JpaTransactionManager(factory);
//	}

}
