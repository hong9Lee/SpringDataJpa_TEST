package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    void crud() {
//        userRepository.save(new User());
//        userRepository.findAll().forEach(System.out::println);

//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//        users.forEach(System.out::println);

        User jack = new User("jack", "jack@naver");
        User jason = new User("jason", "jason@naver");

        userRepository.saveAll(Lists.newArrayList(jack, jason));
        List<User> all = userRepository.findAll();
        all.forEach(System.out::println);

//        User one = userRepository.getOne(1L);
//        System.out.println("one = " + one);

        User user = userRepository.findById(1L).orElse(null);
        System.out.println("user = " + user);


    }

}
