package com.challengers.repo;

import com.challengers.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Malika(mxp134930) on 11/15/2015.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
