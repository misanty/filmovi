package org.egitim.spring.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.egitim.spring.model.service.ActorService;
import org.egitim.spring.model.service.FilmActorService;
import org.egitim.spring.model.service.FilmService;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("org.egitim.spring.model.data.repository")
public class ApplicationConfiguration {
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		localContainerEntityManagerFactoryBean.setPackagesToScan("org.egitim.spring.model.data.entity");
		localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProps());
		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/filmovi");
		dataSource.setUsername("yazilimkoyu");
		dataSource.setPassword("pass");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}

	Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hbm2ddl.auto", "none");
		return properties;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	FilmService getFilmService() {
		return new FilmService();
	}
	
	@Bean
	ActorService getActorService() {
		return new ActorService();
	}
	
	@Bean
	FilmActorService getFilmActorService() {
		return new FilmActorService();
	}

}
