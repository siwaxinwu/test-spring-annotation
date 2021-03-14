package com.roy.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * 多数据源配置
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 9:55 2021-03-14
 */
@Configuration
public class ProfileConfig {
  @Profile("dev")
  @Bean("devDataSource")
  public DataSource dataSourceDev() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://192.168.159.130:3306/commonMapper");
    dataSource.setUser("root");
    dataSource.setPassword("123456");
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    return dataSource;
  }

  @Profile("test")
  @Bean("testDataSource")
  public DataSource dataSourceTest() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://192.168.159.130:3306/commonMapper");
    dataSource.setUser("root");
    dataSource.setPassword("123456");
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    return dataSource;
  }

  @Profile("prod")
  @Bean("prodDataDource")
  public DataSource dataSourceProd() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://192.168.159.130:3306/commonMapper");
    dataSource.setUser("root");
    dataSource.setPassword("123456");
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    return dataSource;
  }
}
