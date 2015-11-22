package com.challengers.controller;

import com.challengers.repo.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Malika(mxp134930) on 11/21/2015.
 */

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/getbooks")
    public String getAllBooks() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookRepository.findAll());
    }

    @RequestMapping("/title/{bookTitle}")
    public String getByName(@PathVariable String bookTitle) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookRepository.findByBookTitle(bookTitle));
    }

    @RequestMapping("/author/{authorName}")
    public String getByAuthor(@PathVariable String authorName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookRepository.findByAuthorName(authorName));
    }

    @RequestMapping("/publisher/{publisherName}")
    public String getByPublisher(@PathVariable String publisherName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookRepository.findByPublisherName(publisherName));
    }

    @RequestMapping("/isbn/{isbn}")
    public String getByIsbn(@PathVariable String isbn) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookRepository.findByIsbn(isbn));
    }

    @RequestMapping("/language/{language}")
    public String getByLanguage(@PathVariable String language) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookRepository.findByLanguage(language));
    }
}
