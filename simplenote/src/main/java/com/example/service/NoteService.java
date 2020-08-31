package com.example.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.NoteDto;


public interface NoteService {
	// Displays all the notes from the database
	public List<NoteDto> findAll();
	
	// Searches the database for the given id and returns the corresponding object
	public NoteDto findById(int id);
	
	// Inserts a record in the database
	public NoteDto addNote(NoteDto note);
	
	// Delets the given object from the database
	public NoteDto deleteNote(NoteDto note);
	
	// returns all the objects which are having same status from the database
	public List<NoteDto> findAllByStatus(String status);
}
