package com.example.service;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.mockito.Mockito;
import com.example.controller.HomeController;
import com.example.dto.NoteDto;
import com.example.utils.Testutils;
import static com.example.utils.Testutils.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(HomeController.class)

public class NoteControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NoteServiceImpl noteService;
	@Test
	public void testAddNote() throws Exception {
		
		  NoteDto notesdto = new NoteDto(); 
		  notesdto.setAuthor("Praveen");
		  
		  Mockito.when(noteService.addNote(notesdto)).thenReturn(notesdto);
		  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
		  .content(Testutils.toJson(notesdto)).contentType(org.springframework.http.
		  MediaType.APPLICATION_JSON)
		  .accept(org.springframework.http.MediaType.APPLICATION_JSON); MvcResult
		  result = mockMvc.perform(requestBuilder).andReturn(); 
		  int x = result.getResponse().getStatus();
		 
		yakshaAssert(currentTest(), (x==201?"true":"false"), exceptionTestFile);
	}
	@Test
	public void testDeleteNote() throws Exception {
		
		  NoteDto notesdto = new NoteDto(); notesdto.setId(1001);
		  when(noteService.addNote(notesdto)).thenReturn(notesdto); RequestBuilder
		  requestBuilder = MockMvcRequestBuilders.get("/noteservice/delete")
		  .content(Testutils.toJson(notesdto)).contentType(org.springframework.http.
		  MediaType.APPLICATION_JSON)
		  .accept(org.springframework.http.MediaType.APPLICATION_JSON); MvcResult
		  result = mockMvc.perform(requestBuilder).andReturn(); 
		  int x =  result.getResponse().getStatus();
		 
		yakshaAssert(currentTest(),(x==201?"true":"false"), exceptionTestFile);
	}
	
	

}
