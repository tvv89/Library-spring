package com.epam.spring.library.converter;

import com.epam.spring.library.model.StatusUser;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<StatusUser, String> {
    @Override
    public String convertToDatabaseColumn(StatusUser attribute) {
        if (attribute== null) {
            return null;
        }
        return attribute.name().toLowerCase();
    }

    @Override
    public StatusUser convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(StatusUser.values())
                .filter(c -> dbData.equalsIgnoreCase(c.name()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
