package com.epam.spring.library.converter;

import com.epam.spring.library.model.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Long> {
    @Override
    public Long convertToDatabaseColumn(Role attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId();
    }

    @Override
    public Role convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Role.values())
                .filter(c -> dbData.equals(c.getId()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
