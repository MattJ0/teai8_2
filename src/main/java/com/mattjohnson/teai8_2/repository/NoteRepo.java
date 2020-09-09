package com.mattjohnson.teai8_2.repository;

import com.mattjohnson.teai8_2.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

    List<Note> findAllByUserId(Integer userId);
}
