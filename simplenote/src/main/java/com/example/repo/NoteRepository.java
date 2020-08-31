package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.NoteDto;
import com.example.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{

}
