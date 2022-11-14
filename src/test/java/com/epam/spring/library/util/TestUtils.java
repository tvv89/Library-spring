package com.epam.spring.library.util;

import com.epam.spring.library.model.Role;
import com.epam.spring.library.model.StatusUser;
import com.epam.spring.library.model.User;

import java.time.LocalDate;

public class TestUtils {
    public static long USER_ID = 2L;
    public static String USER_NUMBER = "84562311";
    public static String USER_PASSWORD = "ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c";
    public static String USER_FIRST_NAME = "Julia";
    public static String USER_LAST_NAME = "Cross";
    public static String USER_EMAIL = "";
    public static LocalDate USER_DATE_OF_BIRTH = LocalDate.parse("1990-02-13");
    public static String USER_PHONE = "+380991234560";
    public static StatusUser USER_STATUS = StatusUser.ENABLED;
    public static String USER_PHOTO = "84562311.jpg";
    public static Role USER_ROLE = Role.USER;
    public static String USER_LOCALE = "en";

    public static User createUser() {
        return new User(USER_ID,
                USER_NUMBER,
                USER_PASSWORD,
                USER_FIRST_NAME,
                USER_LAST_NAME,
                USER_EMAIL,
                USER_DATE_OF_BIRTH,
                USER_PHONE,
                USER_STATUS,
                USER_PHOTO,
                USER_ROLE,
                USER_LOCALE);
    }

}
