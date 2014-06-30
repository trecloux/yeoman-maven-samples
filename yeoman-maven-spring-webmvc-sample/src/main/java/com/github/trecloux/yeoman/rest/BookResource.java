package com.github.trecloux.yeoman.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
public class BookResource {
    private Set<Book> books = new HashSet<Book>();

    public BookResource() {
        for (int i = 0; i < 10; i++) {
            books.add(new Book(i, "Title " + i, "Author " + i));
        }
    }

    @RequestMapping(method = GET, value = "/books")
    public Collection<Book> listAll() {
        log.debug("Listing all {} books", books.size());
        return books;
    }
}
