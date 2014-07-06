package com.github.trecloux.yeoman.rest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookResourceTest {
    @Test
    public void should_list_all_books() throws Exception {
        assertThat(new BookResource().listAll()).hasSize(10);
    }
}
