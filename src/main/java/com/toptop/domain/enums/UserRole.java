package com.toptop.domain.enums;

public enum UserRole {

    /**
     * System administrator.
     */
    ADMIN("ADMIN"),

    /**
     * Manager (system user).
     */
    MANAGER("MANAGER"),

    /**
     * Accountant (system user).
     */
    ACCOUNTANT("ACCOUNTANT");

    UserRole(String name) {
    }
}
