package com.data.jpa.datajpa.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("jason@naver.com");
        user.setName("jason");

        System.out.println("user = " + user);


//        User user1 = new User(null, "1", "2", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("11", "@2");

        User jason = User.builder().name("jason").email("naver.com").build();
        System.out.println("jason = " + jason);
    }



}
