package com.data.jpa.datajpa.service;

import com.data.jpa.datajpa.domain.User;
import com.data.jpa.datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

//        userRepository.save(user);
        em.persist(user);
//        em.detach(user);

        user.setName("newUserAfterPersist");
//        em.merge(user);

        User user1 = userRepository.findById(1L).get();
        em.remove(user1);
    }
}
