package com.challengers.controller;

import com.challengers.dto.BookDto;
import com.challengers.entities.Book;
import com.challengers.repo.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

/**
 * Created by Malika(mxp134930) on 11/21/2015.
 */

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/getbooks")
    public ResponseEntity<List<Book>> getAllBooks() throws JsonProcessingException {

        System.out.println("\nRequesting all books.");
        List <Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping("/title/{bookTitle}")
    public ResponseEntity<List<Book>> getByName(@PathVariable String bookTitle) throws JsonProcessingException {

        System.out.println("\nRequesting book with title: " + bookTitle);
        List<Book> books = bookRepository.findByBookTitle(bookTitle);
        return new ResponseEntity<>(books, HttpStatus.OK);

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

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        Book book = new Book(bookDto.getBookTitle(),bookDto.getAuthorNames(), bookDto.getPublisherNames(), bookDto.getPublishedYear(),
                bookDto.getIsbn(), bookDto.getLanguage(), bookDto.getPrice(), bookDto.getQuantity(), bookDto.getSold());
        bookRepository.save(book);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand()
                .toUri());
        return new ResponseEntity<>("Book Added Successfully, book id : " + book.getBookId(), httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updatebook/{bookId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto){
        Book book = bookRepository.findOne(bookId);
        HttpHeaders httpHeaders = new HttpHeaders();
        if(book != null){
            book.setBookTitle(bookDto.getBookTitle());
            book.setAuthorNames(bookDto.getAuthorNames());
            book.setPublisherNames(bookDto.getPublisherNames());
            book.setPublishedYear(bookDto.getPublishedYear());
            book.setIsbn(bookDto.getIsbn());
            book.setLanguage(bookDto.getLanguage());
            book.setPrice(bookDto.getPrice());
            book.setQuantity(bookDto.getQuantity());
            book.setSold(bookDto.getSold());
            bookRepository.save(book);

            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());
            return new ResponseEntity<>("Book Updated Successfully", httpHeaders, HttpStatus.OK);
        }
        else {
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());
            return new ResponseEntity<>("Book not found, book Id : " + bookId, httpHeaders, HttpStatus.NOT_FOUND);

        }
    }
}
