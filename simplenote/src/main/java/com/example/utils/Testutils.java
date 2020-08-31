package com.example.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.NoteDto;
import com.example.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
public class Testutils {
	public static File businessTestFile;
	public static File boundaryTestFile;
	public static File exceptionTestFile;
	static {
		businessTestFile = new File("./output_revised.txt");
		businessTestFile.delete();
		
		boundaryTestFile = new File("./output_boundary_revised.txt");
		boundaryTestFile.delete();
		
		exceptionTestFile = new File("./output_exception_revised.txt");
		exceptionTestFile.delete();
	}
	public static void yakshaAssert(String testName, Object result, File file) throws IOException {
		
		System.out.println("\n" + testName + "=" + result);
		FileWriter writer = new FileWriter(file,true);
		writer.append("\n" + testName + "=" + result);
		writer.flush();
		writer.close();
	}
	public static String currentTest() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	public static Note convertToNote(NoteDto notedto) {
		Note note = new Note();
		note.setAuthor(notedto.getAuthor());
		note.setDescription(notedto.getDescription());
		note.setId(notedto.getId());
		note.setStatus(notedto.getStatus());
		note.setTitle(notedto.getTitle());
		return note;
		
	}
	public static NoteDto convertToNoteDto(Note note) {
		NoteDto notedto = new NoteDto();
		notedto.setAuthor(note.getAuthor());
		notedto.setDescription(note.getDescription());
		notedto.setId(note.getId());
		notedto.setStatus(note.getStatus());
		notedto.setTitle(note.getTitle());
		return notedto;
	}
	public static List<NoteDto> convertToNoteDtoList(List<Note> notelist){
		List<NoteDto> dtolist = new ArrayList();
		for(Note note : notelist) {
			dtolist.add(convertToNoteDto(note));
		}
		return dtolist;
	}
	public static Note createNote() {
		Note note = new Note();
		note.setId(10001);
		note.setAuthor("Praveen");
		note.setDescription("This is test description");
		note.setTitle("test title");
		note.setStatus("pending");
		return note;
	}
	public static NoteDto createNoteDto() {
		NoteDto note = new NoteDto();
		note.setId(10001);
		note.setAuthor("Praveen");
		note.setDescription("This is test description");
		note.setTitle("test title");
		note.setStatus("pending");
		return note;
	}
	public static List<Note> createNoteList(){
		List<Note> list = new ArrayList();
		list.add(createNote());
		list.add(createNote());
		return list;
	}
	 public static byte[] toJson(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsBytes(object);
	    }
	
}
