package com.challengers.entities;

import com.challengers.util.UniqueIdGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Malika(mxp134930) on 11/14/2015.
 */

@Table(name= "transaction")
@Entity
public class Transaction {
    @Id
    @Column(name = "transaction_Id")
    private Long transactionId;

    @Column(name = "user_id")
    private Long userId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="book_transaction_info", joinColumns=@JoinColumn(name="transaction_id"))
    @AttributeOverrides({
            @AttributeOverride(name="bookId", column = @Column(name="book_Id")),
            @AttributeOverride(name="quantitySold", column = @Column(name="quantity_sold")),
    })
    private Set<BookTransactionInfo> bookTransactionInfo = new HashSet<>();

    public Transaction() {
    }

    public Transaction(Long userId, Set<BookTransactionInfo> bookTransactionInfo) {
        this.transactionId = UniqueIdGenerator.generateId();
        this.userId = userId;
        this.bookTransactionInfo = bookTransactionInfo;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<BookTransactionInfo> getBookTransactionInfo() {
        return bookTransactionInfo;
    }

    public void setBookTransactionInfo(Set<BookTransactionInfo> bookTransactionInfo) {
        this.bookTransactionInfo = bookTransactionInfo;
    }
}
