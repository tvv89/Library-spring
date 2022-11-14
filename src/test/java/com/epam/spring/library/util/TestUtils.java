package com.epam.spring.library.util;

import com.epam.spring.library.model.*;

import java.time.LocalDate;
import java.util.Set;

public class TestUtils {
    //User string constants
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

    //Author constants
    public static long AUTHOR_ID = 9L;
    public static String AUTHOR_FIRST_NAME = "Джордж";
    public static String AUTHOR_LAST_NAME = "Орвелл";
    //Book constants
    public static long BOOK_ID = 1L;
    public static String BOOK_ISBN = "9789662355574";
    public static String BOOK_NAME = "1984";
    public static String BOOK_YEAR = "2015";
    public static String BOOK_IMAGE = "1.jpg";
    public static int BOOK_COUNT = 0;

    //Publisher constants
    public static long PUBLISHER_ID = 1L;
    public static String PUBLISHER_NAME = "Видавництво Жупанського";
    public static String PUBLISHER_ADDRESS = "";
    public static String PUBLISHER_PHONE = "";
    public static String PUBLISHER_CITY = "";

    //Genre constants
    public static long GENRE_ID = 1L;
    public static String GENRE_NAME = "Фантастика";

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

    public static Author createAuthor(){
      return new Author(AUTHOR_ID,
              AUTHOR_FIRST_NAME,
              AUTHOR_LAST_NAME);
    }
    public static Publisher createPublisher() {
        return new Publisher(PUBLISHER_ID,
                PUBLISHER_NAME,
                PUBLISHER_ADDRESS,
                PUBLISHER_PHONE,
                PUBLISHER_CITY);
    }

    public static Genre createGenre() {
        return new Genre(GENRE_ID, GENRE_NAME);
    }

    public static Book createBook() {
        Author author = createAuthor();
        Publisher publisher = createPublisher();
        Genre genre = createGenre();
        return new Book(BOOK_ID,
                BOOK_ISBN,
                BOOK_NAME,
                Set.of(author),
                publisher,
                BOOK_YEAR,
                Set.of(genre),
                BOOK_IMAGE,
                BOOK_COUNT);
    }

}
