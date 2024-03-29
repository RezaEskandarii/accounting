package com.accounting.config;

public abstract class APIConfig {
    public static final String API_VERSION = "/api/v1";

    public static final String ACCOUNTS_CONTROLLER = API_VERSION + "/accounts";
    public static final String ACCOUNT_GROUPS_CONTROLLER = API_VERSION + "/account-groups";
    public static final String USERS_CONTROLLER = API_VERSION + "/users";
    public static final String BOOKS_CONTROLLER = API_VERSION + "/books";
    public static final String JOURNALS_CONTROLLER = API_VERSION + "/journals";
    public static final String REPORT_CONTROLLER = API_VERSION + "/reports";
    public static final String AUTH_CONTROLLER = "/api/auth";
}
