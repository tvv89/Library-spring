package com.epam.spring.library.model;

import java.util.Arrays;

public enum Role {
    USER (3),
    LIBRARIAN (2),
    ADMIN (1);

    private final long id;

    Role(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public static Role getRole(long value)
    {
        return Arrays.stream(Role.values()).filter(s->s.id==value).findAny().orElse(null);
    }

}
