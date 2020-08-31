package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NoteDto;
import com.example.model.Note;
import com.example.service.NoteService;
import com.example.service.NoteServiceImpl;
import static com.example.utils.Testutils.*
;@RestController
public class HomeController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/test")
	public String test() {
		return "hello from controller";
	}
	/*
	 *  This method will return all the available notes as response entity
	 */
	@GetMapping("/all")
	public ResponseEntity<List<NoteDto>> findAll(){
		//return new ResponseEntity(noteService.findAll(),HttpStatus.OK);
		return null;
	}
	
	
	/*
	 * This method will add the given json note from the request body to the database
	 */
	
	@PostMapping("/add")
	public ResponseEntity<NoteDto> addnote(@RequestBody NoteDto notedto){
		
		//return new ResponseEntity(noteService.addNote(notedto), HttpStatus.OK);
		return null;
	}
	
	/*
	 * This method will delete the given json object from the request body in database
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<NoteDto> deletenote(@RequestBody NoteDto notedto){
		//noteService.deleteNote(notedto);
	//	return new ResponseEntity<NoteDto>(notedto, HttpStatus.OK);
		return null;
	}
	
	/*
	 * This method will the find the note corresponding to the given id
	 */
	@GetMapping("/note/{id}")
	public ResponseEntity<NoteDto> getNoteById(@PathVariable("id") int id){
		return null;
	}
	
	/*
	 * This method will return all the note which have the given status in the 
	 * form of response entity.
	 */
	@GetMapping("/status")
	public ResponseEntity<List<NoteDto>> getNotesByStatus(@PathVariable("status") String status){
		return null;
	}
}
