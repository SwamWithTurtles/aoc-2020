package com.swamwithturtles.password;

public class PasswordEntry {

    private final Policy passwordPolicy;
    private final String password;

    public PasswordEntry(Policy passwordPolicy, String password) {
        this.passwordPolicy = passwordPolicy;
        this.password = password;
    }

    public Policy getPasswordPolicy() {
        return passwordPolicy;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCompliant() {
        return passwordPolicy.isCompliant(password);
    }
}
