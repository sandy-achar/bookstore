package com.challengers;

import com.challengers.entities.Book;
import com.challengers.entities.BookTransactionInfo;
import com.challengers.entities.Transaction;
import com.challengers.entities.User;
import com.challengers.repo.BookRepository;
import com.challengers.repo.TransactionRepository;
import com.challengers.repo.UserRepository;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
public class BookstoreCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BookstoreCoreApplication.class, args);
        TransactionRepository transactionRepository = applicationContext.getBean(TransactionRepository.class);
        Set<BookTransactionInfo> bookTransactionInfos = new HashSet<>();
        bookTransactionInfos.add(new BookTransactionInfo(1978185706830476223L, 2));
        Transaction transaction = new Transaction(4696283733126237149L, bookTransactionInfos);
       // transactionRepository.save(transaction);

        BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
        bookRepository.deleteAll();
        System.out.println("books deleted#######################");

        List<Book> books = new ArrayList<>();
        /*for(int i =0; i < 10; i++) {
            Set<String> authors = new HashSet<>();
            authors.add("John Benoit");
            authors.add("Tony Cole");
            Set<String> publishers = new HashSet<>();
            publishers.add("abc publications");
            Book book1 = new Book("NoSQL", authors, publishers, 2004, "abc123456789", "English", 30.50, 5, 2);
            books.add(book1);
        }*/

        //Add some books with unique isbn
        Set<String> authors = new HashSet<>();
        authors.add("John Benoit");
        authors.add("Tony Cole");
        Set<String> publishers = new HashSet<>();
        publishers.add("abc publications");

        Book book1 = new Book("NoSQL", authors, publishers, 2004, "abc123456789", "English", 30.50, 5, 2);
        Book book2 = new Book("NoSQL", authors, publishers, 2004, "abc123456790", "English", 30.50, 5, 2);
        Book book3 = new Book("NoSQL", authors, publishers, 2004, "abc123456791", "English", 30.50, 5, 2);
        Book book4 = new Book("NoSQL", authors, publishers, 2004, "abc123456792", "English", 30.50, 5, 2);
        Book book5 = new Book("NoSQL", authors, publishers, 2004, "abc123456793", "English", 30.50, 5, 2);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        bookRepository.save(books);

        System.out.println("Books Created " + bookRepository.findAll().size());

        /*UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        User user1 = new User("malika", "malika", "Malika Pahva", null, null, null, null, null, null, null);
        User user2 = new User("sandesh", "sandesh", "Sandesh", null, null, null, null, null, null, null);
        User user3 = new User("sufian", "sufian", "Sufian", null, null, null, null, null, null, null);

        // Add Users to database
        List<User> users = Arrays.asList(user1, user2, user3);
        userRepository.save(users);*/

        //Delete a user
        //userRepository.delete(2725442848095386635L);

        //Find all users
        /*List<User> all = userRepository.findAll();
        for (User user : all) {
            System.out.println(user.getPassword());
        }*/

        //update name
       /* User userToUpdate = userRepository.findOne(4696283733126237149L);
        userToUpdate.setFirstName("Malika");
        userRepository.save(userToUpdate);*/
       /* User userByFirstName = userRepository.findByFirstName("Malika");
        System.out.println(userByFirstName);*/
    }
}
