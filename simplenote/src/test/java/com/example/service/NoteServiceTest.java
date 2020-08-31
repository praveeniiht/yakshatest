package com.example.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static com.example.utils.Testutils.*;
import com.example.dto.NoteDto;
import com.example.model.Note;
import com.example.repo.NoteRepository;
import com.example.utils.Testutils;
import static org.junit.Assert.*;
public class NoteServiceTest {
	
	@Mock
	NoteRepository noteRepository;
	@Mock
	NoteServiceImpl noteService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() throws Exception {
		//fail("Not yet implemented");
		List<NoteDto> expectedList = convertToNoteDtoList(Testutils.createNoteList());
		Mockito.when(noteService.findAll()).thenReturn(expectedList);
		List<NoteDto> actualList = noteService.findAll();
		yakshaAssert(currentTest(),(actualList.size()==2?"true":"false"),businessTestFile);

	}

	@Test
	public void testFindById() throws IOException {
		Note note = createNote();
		Mockito.when(noteService.findById(10001)).thenReturn(convertToNoteDto(note));
		String author = noteService.findById(10001).getAuthor();
		yakshaAssert(currentTest(),(author.equals("Praveen")?"true":"false"),businessTestFile);
	}

	@Test
	public void testAddNote() throws Exception {
		NoteDto notedto = createNoteDto();
		Mockito.when(noteService.addNote(notedto)).thenReturn(notedto);
		int id = (int) noteService.addNote(notedto).getId();
		yakshaAssert(currentTest(),(id>=0?"true":"false"),businessTestFile);
	}

	@Test
	public void testDeleteNote() throws Exception {
		//fail("Not yet implemented");
		NoteDto notedto = createNoteDto();
		Mockito.when(noteService.deleteNote(notedto)).thenReturn(notedto);
		NoteDto actual = noteService.findById((int)notedto.getId());
		yakshaAssert(currentTest(),(actual==null?"true":"false"),businessTestFile);
	}

	@Test
	public void testFindAllByStatus() throws Exception{
		List<Note> list = createNoteList();
		Mockito.when(noteService.findAllByStatus("pending")).thenReturn(convertToNoteDtoList(list));
		List<NoteDto> statusList = noteService.findAllByStatus("pending");
		boolean flag = (statusList.get(0).getStatus()).equals(statusList.get(1).getStatus());
		yakshaAssert(currentTest(),flag,businessTestFile);
	}

}
