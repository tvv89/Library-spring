package com.epam.spring.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String city;
}
