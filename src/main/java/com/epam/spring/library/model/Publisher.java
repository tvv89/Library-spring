package com.epam.spring.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@EqualsAndHashCode
@Component
public class Publisher {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String city;
}
