package com.mattjohnson.teai8_2.repository;

import com.mattjohnson.teai8_2.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
}
