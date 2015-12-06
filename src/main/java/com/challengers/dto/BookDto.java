package com.challengers.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Malika(mxp134930) on 12/1/2015.
 */
public class BookDto {
    private Long bookId;

    private String bookTitle;

    private Set<String> authorNames = new HashSet<>();

    private Set<String> publisherNames = new HashSet<>();

    private int publishedYear;

    private String isbn;

    private String language;

    private double price;

    private int quantity;

    private int sold;

    public BookDto() {
    }

    public BookDto(Long bookId, String bookTitle, Set<String> authorNames, Set<String> publisherNames, int publishedYear, String isbn, String language, double price, int quantity, int sold) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorNames = authorNames;
        this.publisherNames = publisherNames;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
          this.language = language;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Set<String> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(Set<String> authorNames) {
        this.authorNames = authorNames;
    }

    public Set<String> getPublisherNames() {
        return publisherNames;
    }

    public void setPublisherNames(Set<String> publisherNames) {
        this.publisherNames = publisherNames;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
