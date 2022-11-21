package com.epam.spring.library.controller;

import com.epam.spring.library.LibraryApplication;
import com.epam.spring.library.config.TestApplicationConfig;
import com.epam.spring.library.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
    Create integration test with test DB in memory
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = LibraryApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Import(TestApplicationConfig.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getBooks() throws Exception {
        mockMvc.perform(get("/books")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNumber());
    }

    @Test
    void getBookById() throws Exception {
        mockMvc.perform(get("/books/"+ TestUtils.BOOK_ID)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(TestUtils.BOOK_ID));
    }

    @Test
    void getBookByIdNotFound() throws Exception {
        mockMvc.perform(get("/books/"+ 151)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(404))
                .andExpect(jsonPath("$.errorMessage").value("book not found"));
    }

    @Test
    void createBook() throws Exception {
        String body = """
                {
                    "id": 0,
                    "isbn": "9786176640820",
                    "name": "Гобіт, або Туди і звідти",
                    "authors": [
                        {
                            "id": 8,
                            "firstName": "Джон",
                            "lastName": "Толкін"
                        }
                    ],
                    "publisher": {
                        "id": 6,
                        "name": "Астролябія",
                        "address": "",
                        "phone": "",
                        "city": ""
                    },
                    "years": "2015",
                    "genres": [
                        {
                            "id": 1,
                            "name": "Фантастика"
                        }
                    ],
                    "image": "",
                    "count": 0
                }
                """;
        mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn").value("9786176640820"));

    }

    @Test
    void deleteBook() {
    }

    @Test
    void findBooksByGenre() {
    }

    @Test
    void findBooksByAuthorLastName() {
    }

    @Test
    void findBooksByISBN() {
    }

    @Test
    void updateBook() {
    }
}