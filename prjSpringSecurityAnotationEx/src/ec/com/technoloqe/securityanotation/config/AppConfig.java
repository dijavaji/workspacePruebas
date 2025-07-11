package ec.com.technoloqe.securityanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@ComponentScan({ "ec.com.technoloqe.securityanotation.*" })
//@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig {
	
	/**@Bean
    public SessionFactory sessionFactory() {
            LocalSessionFactoryBuilder builder =
		new LocalSessionFactoryBuilder(dataSource());
            builder.scanPackages("com.mkyong.users.model")
                  .addProperties(getHibernateProperties());

            return builder.buildSessionFactory();
    }**/

	/**private Properties getHibernateProperties() {
	            Properties prop = new Properties();
	            prop.put("hibernate.format_sql", "true");
	            prop.put("hibernate.show_sql", "true");
	            prop.put("hibernate.dialect",
	                "org.hibernate.dialect.MySQL5Dialect");
	            return prop;
	    }**/

	/**@Bean(name = "dataSource")
	public BasicDataSource dataSource() {
	
		BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		return ds;
	}**/

	//Create a transaction manager
	/**@Bean
	    public HibernateTransactionManager txManager() {
	            return new HibernateTransactionManager(sessionFactory());
	    }**/

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
