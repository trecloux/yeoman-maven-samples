package com.github.trecloux.yeoman.rest;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class BookResourceIT {
    private static final String BOOKS_AS_JSON_STRING = "[{\"isbn\":6,\"title\":\"Title 6\",\"author\":\"Author 6\"},{\"isbn\":9,\"title\":\"Title 9\",\"author\":\"Author 9\"},{\"isbn\":0,\"title\":\"Title 0\",\"author\":\"Author 0\"},{\"isbn\":4,\"title\":\"Title 4\",\"author\":\"Author 4\"},{\"isbn\":2,\"title\":\"Title 2\",\"author\":\"Author 2\"},{\"isbn\":8,\"title\":\"Title 8\",\"author\":\"Author 8\"},{\"isbn\":5,\"title\":\"Title 5\",\"author\":\"Author 5\"},{\"isbn\":1,\"title\":\"Title 1\",\"author\":\"Author 1\"},{\"isbn\":3,\"title\":\"Title 3\",\"author\":\"Author 3\"},{\"isbn\":7,\"title\":\"Title 7\",\"author\":\"Author 7\"}]";

    @Test
    public void should_list_ten_books() throws Exception {
        MockMvc server = standaloneSetup(new BookResource()).build();
        server.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(BOOKS_AS_JSON_STRING));
    }
}
