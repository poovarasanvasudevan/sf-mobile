package com.caretech.servicefocus.mobile.repo;

import com.caretech.servicefocus.mobile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findUserByUserNameAndIsActiveIsTrue(String username);
}
