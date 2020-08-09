package onlineShop;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import onlineShop.log.Logger;
import onlineShop.log.PaymentAction;
import onlineShop.log.ServerLogger;


@Configuration
@EnableWebMvc // with applicationConfig, original "payment.xml" is useless... with @ EnableWebMvc, dispatch servlet need to be built to query the applicationConfig
public class ApplicationConfig {

	@Bean(name = "logger")
	public Logger getLogger() {
	    return new ServerLogger();
	}

	@Bean(name = "paymentAction")
	public PaymentAction getPaymentAction() {
	    return new PaymentAction();
	}
	    
    @Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("onlineShop.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
                     // change to your own RDS_Endpoint
                     // change the username and password
		dataSource.setUrl("jdbc:mysql://laiproject-instance.c7t5cnj6wfy1.us-east-2.rds.amazonaws.com:3306/ecommerce?serverTimezone=UTC");
		dataSource.setUsername("admin");
		dataSource.setPassword("Yuriao1994");

		return dataSource;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // check table updates and upload
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return hibernateProperties;
	}
}
