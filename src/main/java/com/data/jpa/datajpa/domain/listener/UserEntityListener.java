package com.data.jpa.datajpa.domain.listener;

import com.data.jpa.datajpa.domain.User;
import com.data.jpa.datajpa.domain.UserHistory;
import com.data.jpa.datajpa.repository.UserHistoryRepository;
import com.data.jpa.datajpa.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

    @PrePersist
    @PreUpdate
    public void prePersisteAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User)o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
