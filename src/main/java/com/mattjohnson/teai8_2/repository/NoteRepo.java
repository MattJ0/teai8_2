package com.mattjohnson.teai8_2.repository;

import com.mattjohnson.teai8_2.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

    List<Note> findAllByUserId(Integer userId);

    List<Note> findAllByUserIdAndRemoved(Integer userId, boolean removed);

    Optional<Note> findByIdAndRemoved(Integer id, boolean removed);


//    void deleteAllByUser(Integer userId);

}
