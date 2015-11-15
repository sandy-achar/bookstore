package com.challengers.repo;

import com.challengers.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Malika(mxp134930) on 11/15/2015.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
