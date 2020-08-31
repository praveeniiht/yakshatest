package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.NoteDto;
import com.example.model.Note;
import com.example.repo.NoteRepository;
import com.example.utils.Testutils;

@Service
@Transactional
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<NoteDto> findAll() {
		// TODO Auto-generated method stub
		//return Testutils.convertToNoteDtoList(noteRepository.findAll());
		return null;
	}

	@Override
	public NoteDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteDto addNote(NoteDto note) {
		// TODO Auto-generated method stub
		//Note note1 = Testutils.convertToNote(note);
		//noteRepository.save(note1);
		//return note;
		return null;
	}

	@Override
	public NoteDto deleteNote(NoteDto note) {
		// TODO Auto-generated method stub
	//	noteRepository.delete(Testutils.convertToNote(note));
	//	return note;
		return null;
	}

	@Override
	public List<NoteDto> findAllByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
