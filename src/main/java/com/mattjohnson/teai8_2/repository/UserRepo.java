package com.mattjohnson.teai8_2.repository;

import com.mattjohnson.teai8_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findAllByNameOrEmail(String name, String email);

    boolean existsUserByName(String name);

    boolean existsUserByEmail(String email);

}
