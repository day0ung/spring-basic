package com.basic.next.config.site;

import com.basic.next.config.DBConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(prefix = "spring.", name = "datasource-site.use", havingValue = "true", matchIfMissing = false)
@MapperScan(value="com.basic.next.dao", sqlSessionFactoryRef="simpleSqlSessionFactory")
public class SimpleDBConfig {

    @Autowired
    Environment env;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DBConfig dbConfiguration;

    @Bean(name = "simpleDataSource")
    public DataSource simpleDataSource() {
        HikariConfig hikariConfig = dbConfiguration.hikariConfig();
        hikariConfig.setJdbcUrl(env.getProperty("spring.datasource-site.url"));
        DataSource db = new HikariDataSource(hikariConfig);
        return db;
    }

    @Bean(name = "simpleSqlSessionFactory")
    public SqlSessionFactory simpleSqlSessionFactory(@Qualifier("simpleDataSource") DataSource simpleDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(simpleDataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mapper/mapper.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/sql/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "simpleSqlSessionTemplate")
    public SqlSessionTemplate simpleSqlSessionTemplate(SqlSessionFactory simpleSqlSessionFactory) {
        return new SqlSessionTemplate(simpleSqlSessionFactory);
    }

}
