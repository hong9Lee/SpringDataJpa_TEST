package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;


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

//        User jack = new User("jack", "jack@naver");
//        User jason = new User("jason", "jason@naver");
//
//        userRepository.saveAll(Lists.newArrayList(jack, jason));
//        List<User> all = userRepository.findAll();
//        all.forEach(System.out::println);

//        User one = userRepository.getOne(1L);
//        System.out.println("one = " + one);

//        User user = userRepository.findById(1L).orElse(null);
//        System.out.println("user = " + user);

//        userRepository.saveAndFlush(new User("new martin", "newmartin@naver.com"));
//        userRepository.flush();

//        userRepository.findAll().forEach(System.out::println);

        /*
        long count = userRepository.count();
        System.out.println("count = " + count);

        boolean b = userRepository.existsById(1L);
        System.out.println("b = " + b);


        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));


//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 33L))); // -> 성능 안나옴. 이유는 처음에 모든 데이터를 조회하기때문
        // -> 그래서
//        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 33L)));
        userRepository.deleteAllInBatch();
        userRepository.findAll().forEach(System.out::println);


        // -> 페이징
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
        System.out.println("users = " + users);
        System.out.println("total elem : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numofElem : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size   : " + users.getSize());

        users.getContent().forEach(System.out::println);


        // -> qbe query by example
        ExampleMatcher macher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("ma", "fastcampus.com"), macher);

        userRepository.findAll(example).forEach(System.out::println);



        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);
        userRepository.findAll(example).forEach(System.out::println);


         */

        userRepository.save(new User("david", "david@naver.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@nate.com");

        userRepository.save(user);
    }

}
