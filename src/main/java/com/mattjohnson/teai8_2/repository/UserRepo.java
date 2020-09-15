package com.mattjohnson.teai8_2.repository;

import com.mattjohnson.teai8_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findAllByNameOrEmail(String name, String email);

    Optional<User> findByIdAndRemovedIsFalse(Integer id);

    List<User> findAllByRemovedIsFalse();

    boolean existsUserByNameOrEmail(String name, String email);

    boolean existsUserByEmail(String email);

}
