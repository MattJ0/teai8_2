package com.mattjohnson.teai8_2.repository;

import com.mattjohnson.teai8_2.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

    List<Note> findAllByUserId(Integer userId);

    List<Note> findAllByUserIdAndRemovedIsFalse(Integer userId);

    Optional<Note> findByIdAndRemoved(Integer id, boolean removed);

    @Modifying
    @Query(value = "update teai8_2.notes set removal_date= :removalDate, removed=true where user_id = :userId and removed = false", nativeQuery = true)
    void setRemovedByUser(Integer userId, ZonedDateTime removalDate);
}
