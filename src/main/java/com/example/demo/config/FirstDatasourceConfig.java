package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.first" ,sqlSessionFactoryRef ="firstSqlSessionFactory" )
public class FirstDatasourceConfig {

    //配置数据源
    @ConfigurationProperties(prefix = "spring.datasource.first")
    @Bean(name = "firstDataSource")
    public DataSource firstDataSource(){
        return DataSourceBuilder.create().build();
    }

    //配置sqlsessionFactory
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();


    }

    //数据库事务
    @Bean(name="firstDatasourceTransactionManager")
    public DataSourceTransactionManager firstDatasourceTransactionManager(@Qualifier("firstDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    //配置sqlsessionTemplate
    @Bean(name="firstSqlsessionTemplate")
    public SqlSessionTemplate firstSqlsessionTemplate(@Qualifier("firstSqlSessionFactory")SqlSessionFactory sqlSessionFactory){

        return new SqlSessionTemplate(sqlSessionFactory);
    }



    }






