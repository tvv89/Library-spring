package com.epam.spring.library.model;

public enum StatusUser {
    DISABLED(0),
    ENABLED(1);

    public final int value;
    StatusUser(int value) {
        this.value = value;
    }

}
