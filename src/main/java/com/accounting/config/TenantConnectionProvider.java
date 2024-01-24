package com.accounting.config;

//@Component
//public class TenantConnectionProvider implements MultiTenantConnectionProvider {
//
//    private final DataSource datasource;
//
//    public TenantConnectionProvider(DataSource dataSource) {
//        this.datasource = dataSource;
//    }
//
//    @Override
//    public Connection getAnyConnection() throws SQLException {
//        return datasource.getConnection();
//    }
//
//    @Override
//    public void releaseAnyConnection(Connection connection) throws SQLException {
//        connection.close();
//    }
//
//    @Override
//    public Connection getConnection(String tenantIdentifier) throws SQLException {
//        final Connection connection = getAnyConnection();
//        connection.createStatement()
//                .execute(String.format("SET SCHEMA '%s';", tenantIdentifier));
//        return connection;
//    }
//
//    @Override
//    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
//        connection.createStatement()
//                .execute(String.format("SET SCHEMA '%s';", TenantIdentifierResolver.DEFAULT_TENANT));
//        releaseAnyConnection(connection);
//    }
//
//    @Override
//    public boolean supportsAggressiveRelease() {
//        return false;
//    }
//
//    @Override
//    public boolean isUnwrappableAs(Class unwrapType) {
//        return false;
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> unwrapType) {
//        return null;
//    }
//}