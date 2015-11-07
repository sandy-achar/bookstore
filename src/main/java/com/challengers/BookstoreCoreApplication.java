package com.challengers;

import com.challengers.entities.User;
import com.challengers.repo.UserRepository;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class BookstoreCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BookstoreCoreApplication.class, args);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        User user1 = new User("malika", "malika", "Malika Pahva");
        User user2 = new User("sandesh", "sandesh", "Sandesh");
        User user3 = new User("sufian", "sufian", "Sufian");

        // Add Users to database
        /*List<User> users = Arrays.asList(user1, user2, user3);
        userRepository.save(users);*/

        //Delete a user
        //userRepository.delete(2725442848095386635L);

        //Find all users
       /* List<User> all = userRepository.findAll();
        for (User user : all) {
            System.out.println(user.getFirstName());
        }
*/
        //update name
       /* User userToUpdate = userRepository.findOne(4696283733126237149L);
        userToUpdate.setFirstName("Malika");
        userRepository.save(userToUpdate);*/
        User userByFirstName = userRepository.findByFirstName("Malika");
        System.out.println(userByFirstName);
    }
}
