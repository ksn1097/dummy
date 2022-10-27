package com.camunda.example.SICalculator.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.util.SpringBootProcessEnginePlugin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class CamundaDataSourceConfig {

    private String username;
    private String password;
    private String driverClassName;
    private String url;

    @Bean("camundaDataSource")
    public DataSource dataSource(){
       HikariDataSource dataSource = new HikariDataSource();
       dataSource.setUsername(username);
       dataSource.setPassword(password);
       dataSource.setDriverClassName(driverClassName);
       dataSource.setJdbcUrl(url);
    return dataSource;
    }

    @Bean
    public SpringBootProcessEnginePlugin transactionManagerProcessEnginePlugin(@Qualifier("camundaDataSource") DataSource dataSource){
        return new SpringBootProcessEnginePlugin(){
             @Override
            public void preInit(SpringProcessEngineConfiguration processEngineConfiguration){
                 processEngineConfiguration.setTransactionManager(new DataSourceTransactionManager(dataSource));
             }
        };
    }
}
