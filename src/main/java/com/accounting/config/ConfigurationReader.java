package com.accounting.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Configuration
@PropertySource("classpath:application.properties")
@Component
public class ConfigurationReader {

    @Value("${server.port}")
    public int serverPort;

    @Value("${debug_mode}")
    public boolean debugMode;

    @Value("${spring.datasource.driver-class-name}")
    public String datasourceDriverClassName;

    @Value("${spring.datasource.url}")
    public String datasourceUrl;

    @Value("${spring.datasource.username}")
    public String datasourceUsername;

    @Value("${spring.datasource.password}")
    public String datasourcePassword;

    @Value("${spring.jpa.show-sql}")
    public boolean jpaShowSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    public boolean jpaFormatSql;

    @Value("${spring.jpa.database-platform}")
    public String jpaDatabasePlatform;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String jpaDdlAuto;

    @Value("${spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation}")
    public boolean jpaLobNonContextualCreation;

    @Value("${server.error.whitelabel.enabled}")
    public boolean serverErrorWhitelabelEnabled;

    @Value("${spring.mvc.pathpattern.matching-strategy}")
    public String mvcPathPatternMatchingStrategy;

    @Value("${spring.main.allow-circular-references}")
    public boolean mainAllowCircularReferences;

    @Value("${springdoc.swagger-ui.path}")
    public String swaggerUiPath;

    @Value("${spring.sql.init.mode}")
    public String sqlInitMode;

    @Value("${spring.datasource.platform}")
    public String datasourcePlatform;

//    @Value("${log4j.logger.org.hibernate}")
//    public String hibernateLogger;
//
//    @Value("${log4j.logger.org.hibernate.SQL}")
//    public String hibernateSqlLogger;
//
//    @Value("${log4j.logger.org.hibernate.type}")
//    public String hibernateTypeLogger;
//
//    @Value("${log4j.logger.org.hibernate.hql.ast.AST}")
//    public String hibernateHqlAstLogger;
//
//    @Value("${log4j.logger.org.hibernate.tool.hbm2ddl}")
//    public String hibernateToolLogger;
//
//    @Value("${log4j.logger.org.hibernate.hql}")
//    public String hibernateHqlLogger;
//
//    @Value("${log4j.logger.org.hibernate.cache}")
//    public String hibernateCacheLogger;
//
//    @Value("${log4j.logger.org.hibernate.jdbc}")
//    public String hibernateJdbcLogger;
//
//    @Value("${log4j.appender.hb}")
//    public String hibernateAppender;
//
//    @Value("${log4j.appender.hb.layout}")
//    public String hibernateLayout;
//
//    @Value("${log4j.appender.hb.layout.ConversionPattern}")
//    public String hibernateConversionPattern;
//
//    @Value("${log4j.appender.hb.Threshold}")
//    public String hibernateThreshold;

    @Value("${SerializationFeature.FAIL_ON_EMPTY_BEANS}")
    public boolean serializationFailOnEmptyBeans;

    @Value("${APP.JwtSecret}")
    public String appJwtSecret;

    @Value("${App.JwtExpirationMs}")
    public long appJwtExpirationMs;

    @Value("${App.JwtRefreshExpirationMs}")
    public long appJwtRefreshExpirationMs;
}
