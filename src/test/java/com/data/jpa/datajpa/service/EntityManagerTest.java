package com.data.jpa.datajpa.service;


import com.data.jpa.datajpa.domain.User;
import com.data.jpa.datajpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;




    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFindTest() {
        System.out.println("userRepository = " + userRepository.findById(1L).get());
        System.out.println("userRepository = " + userRepository.findById(1L).get());
        System.out.println("userRepository = " + userRepository.findById(1L).get());

        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrrtin");

        userRepository.save(user);

        user.setEmail("marrrrrrrrrrtin@fastcampus.com");
        userRepository.save(user);

        System.out.println("userRepository = " + userRepository.findAll());
    }
}
