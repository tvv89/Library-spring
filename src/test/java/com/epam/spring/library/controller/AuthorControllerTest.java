package com.epam.spring.library.controller;

import com.epam.spring.library.model.Author;
import com.epam.spring.library.service.impl.AuthorServiceImpl;
import com.epam.spring.library.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthorController.class)
@ActiveProfiles(value = "test")
class AuthorControllerTest {

    @MockBean
    private AuthorServiceImpl authorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAuthors() throws Exception {
        Author author = TestUtils.createAuthor();
        when(authorService.getAllAuthors()).thenReturn(List.of(author));
        mockMvc.perform(get("/authors")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].firstName").value(TestUtils.AUTHOR_FIRST_NAME));
    }

    @Test
    void getAuthorById() throws Exception {
        Author author = TestUtils.createAuthor();
        when(authorService.getAuthorById(TestUtils.AUTHOR_ID)).thenReturn(author);
        mockMvc.perform(get("/authors/" + TestUtils.AUTHOR_ID)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value(TestUtils.AUTHOR_FIRST_NAME));
    }

    @Test
    void createAuthor() throws Exception {
        Author author = TestUtils.createAuthor();
        String jsonBody = """
                {
                    "id": 0,
                    "firstName": "Джордж",
                    "lastName": "Орвелл"
                }""";
        Author authorCreate = new Author();
        authorCreate.setId(0);
        authorCreate.setFirstName(TestUtils.AUTHOR_FIRST_NAME);
        authorCreate.setLastName(TestUtils.AUTHOR_LAST_NAME);
        when(authorService.createAuthor(authorCreate)).thenReturn(author);
        mockMvc.perform(post("/authors").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value(TestUtils.AUTHOR_FIRST_NAME));
    }

    @Test
    void deleteAuthor() throws Exception {
        Author author = TestUtils.createAuthor();
        when(authorService.getAuthorById(TestUtils.AUTHOR_ID)).thenReturn(author);
        mockMvc.perform(delete("/authors/" + TestUtils.AUTHOR_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value(TestUtils.AUTHOR_FIRST_NAME));
    }

    @Test
    void updateAuthor() throws Exception {
        Author author = TestUtils.createAuthor();
        String jsonBody = """
                    {
                    "id": 9,
                    "firstName": "Джордж",
                    "lastName": "Орвелл"
                }""";
        when(authorService.updateAuthor(author)).thenReturn(author);
        mockMvc.perform(put("/authors").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value(TestUtils.AUTHOR_FIRST_NAME));
    }
}