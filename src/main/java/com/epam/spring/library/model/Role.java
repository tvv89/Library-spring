package com.epam.spring.library.model;

import lombok.AllArgsConstructor;

public enum Role {
    USER (0),
    LIBRARIAN (1),
    ADMIN (2);

    public final int value;
    Role(int value) {
        this.value = value;
    }
}
