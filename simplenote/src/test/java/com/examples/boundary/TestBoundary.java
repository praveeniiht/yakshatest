package com.examples.boundary;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static com.example.utils.Testutils.*;

import org.junit.Before;
import org.junit.Test;

import com.example.dto.NoteDto;
import com.example.utils.Testutils;
public class TestBoundary {
	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	@Test
	public void testAuthorNameLength() throws Exception {
		NoteDto note = Testutils.createNoteDto();
		note.setAuthor("Praveenkumar");
		Set<ConstraintViolation<NoteDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testTitleLength() throws Exception {
		NoteDto note = Testutils.createNoteDto();
		note.setTitle("DevOps");
		Set<ConstraintViolation<NoteDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	}
	@Test
	public void testDescriptionLength() throws Exception {
		NoteDto note = Testutils.createNoteDto();
		note.setDescription("This is a famous technology");
		Set<ConstraintViolation<NoteDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	}
}
