package com.accounting.config;

//@Component
//public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {
//
//    static final String DEFAULT_TENANT = "public";
//
//    @Override
//    public String resolveCurrentTenantIdentifier() {
//        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
//                .filter(Predicate.not(authentication -> authentication instanceof AnonymousAuthenticationToken))
//                .map(Principal::getName)
//                .orElse(DEFAULT_TENANT);
//    }
//
//    @Override
//    public boolean validateExistingCurrentSessions() {
//        return true;
//    }
//}