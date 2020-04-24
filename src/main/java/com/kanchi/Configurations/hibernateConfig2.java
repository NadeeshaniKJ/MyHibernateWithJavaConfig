package com.kanchi.Configurations;


import com.kanchi.dto.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

public class hibernateConfig2 {



    public static SessionFactory sessionFactory() {
        SessionFactory sessionFactory ;
        Configuration configuration = new Configuration();
        configuration.setProperties(hibernateProperties());

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties() ).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);



        return sessionFactory;
    }

    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/gamekadetestdb?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

   /* public static HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }*/

    private static Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.url", "jdbc:mysql://localhost:3307/gamekadetestdb?useSSL=false");
        properties.put("hibernate.username", "root");
        properties.put("hibernate.password", "root");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
}
