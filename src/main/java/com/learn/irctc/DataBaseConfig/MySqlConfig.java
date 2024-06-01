package com.learn.irctc.DataBaseConfig;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.learn.irctc.Repo",
		"com.learn.irctc.entities" }, entityManagerFactoryRef = "mysqlEntityManagerFactoryFipData", transactionManagerRef = "mysqlTransactionManager")
public class MySqlConfig extends HikariConfig {

	@Autowired
	private Environment environment;

	@Primary
	@Bean(name = "mysqlDataSourceFipData")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource mysqlDataSourceFipData() {
		return new HikariDataSource();
	}

	@Primary
	@Bean(name = "mysqlEntityManagerFactoryFipData")
	@PersistenceUnit(unitName = "mysqlData")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryFipData(EntityManagerFactoryBuilder builder,
			@Qualifier("mysqlDataSourceFipData") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = builder.dataSource(dataSource).packages("com.learn.irctc.entities")
				.persistenceUnit("mysqlData").build();

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("spring.jpa.show-sql", environment.getProperty("spring.datasource.mysql.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl-auto", environment.getProperty("spring.datasource.mysql.jpa.hibernate.ddl-auto"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Primary
	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("mysqlEntityManagerFactoryFipData") EntityManagerFactory mysqlEntityManagerFactoryFipData) {
		return new JpaTransactionManager(mysqlEntityManagerFactoryFipData);
	}

}
