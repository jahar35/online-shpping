package cm.asad.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.asad.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
//Database configuration varibles:based on the type of database
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	//datasource bean
	@Bean
	private DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		
		//Connection info
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername("DATABASE_USERNAME");
		dataSource.setPassword("DATABASE_PASSWORD");
		return dataSource;
	}
	
	//Session Factory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
	LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
	builder.addProperties(getHibernateProperties());
	builder.scanPackages("com.asad.shoppingbackend.dto");
	return builder.buildSessionFactory();
	}
//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
	//Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);	
	return transactionManager;
	}
	
}
