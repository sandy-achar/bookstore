package com.challengers.entities;

/**
 * Created by Malika(mxp134930) on 11/14/2015.
 */
public class BookTransactionInfo {
    private Long bookId;
    private int quantitySold;

    public BookTransactionInfo() {
    }

    public BookTransactionInfo(Long bookId, int quantitySold) {
        this.bookId = bookId;
        this.quantitySold = quantitySold;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
}
