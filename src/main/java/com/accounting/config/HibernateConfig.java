package com.accounting.config;

//
//@Configuration
//public class HibernateConfig {
//
//
//    final ConfigurationReader configurationReader;
//    final DatabaseCreator databaseCreator;
//
//    public HibernateConfig(ConfigurationReader configurationReader, DatabaseCreator databaseCreator) {
//        this.configurationReader = configurationReader;
//        this.databaseCreator = databaseCreator;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, @NotNull JpaProperties jpaProperties,
//                                                                       MultiTenantConnectionProvider multiTenantConnectionProvider,
//                                                                       CurrentTenantIdentifierResolver tenantIdentifierResolver) {
//
//
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan(AccountingApplication.class.getPackage().getName());
//        em.setJpaVendorAdapter(jpaVendorAdapter());
//
//        Map<String, Object> jpaPropertiesMap = new HashMap<>(jpaProperties.getProperties());
//        jpaPropertiesMap.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
//        jpaPropertiesMap.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
//        jpaPropertiesMap.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantIdentifierResolver);
//        jpaPropertiesMap.put(Environment.SHOW_SQL, configurationReader.jpaShowSql);
//        jpaPropertiesMap.put(Environment.FORMAT_SQL, configurationReader.jpaFormatSql);
//        jpaPropertiesMap.put(Environment.HBM2DDL_AUTO, configurationReader.jpaDdlAuto);
//        jpaPropertiesMap.put(Environment.DIALECT, configurationReader.jpaDatabasePlatform);
//        jpaPropertiesMap.put("spring.jpa.generate-ddl", "create");
//
//        em.setJpaPropertyMap(jpaPropertiesMap);
//
//        return em;
//    }
//}