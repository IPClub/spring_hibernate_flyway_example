package com.tasks.TaskManager.model;

public enum Status {
    NOT_STARTED("NOT_STARTED"),IN_PROGRESS("IN_PROGRESS"),ENDED("ENDED");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
