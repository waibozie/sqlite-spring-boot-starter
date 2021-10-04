package com.github.waibozie.sqlite.autoconfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.sqlite.JDBC;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(JDBC.class)
@EnableConfigurationProperties(SQLiteProperties.class)
public class SQLiteAutoConfiguration {
    private static final Log logger = LogFactory.getLog(SQLiteAutoConfiguration.class);
    private static final String DEFAULT_DB_FILE = "sqlite_default.db";

    @Bean
    public DataSource dataSource(SQLiteProperties properties) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(JDBC.class.getCanonicalName());

        if (properties.getUrl() != null) {
            dataSource.setUrl(properties.getUrl());
        } else if (properties.getFile() != null) {
            dataSource.setUrl("jdbc:sqlite:" + properties.getFile());
        } else {
            dataSource.setUrl("jdbc:sqlite:" + DEFAULT_DB_FILE);
            logger.warn("there is no configuration for 'sqlite.url' or 'sqlite.file' found, use default '" + DEFAULT_DB_FILE + "'. Explicitly configure 'sqlite.url' or 'sqlite.file' to disable this warning");
        }

        return dataSource;
    }
}