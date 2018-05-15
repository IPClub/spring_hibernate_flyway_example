package com.tasks.TaskManager.model;

public enum Severity {
    EASY("EASY"),MEDIUM("MEDIUM"),HARD("HARD");

    private final String value;

    Severity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
