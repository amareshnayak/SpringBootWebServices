package com.amazon.alexa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.amazon.alexa.ApplicationTest;

@RunWith(SpringJUnit4ClassRunner.class)

public class ReviewControllerTest extends ApplicationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testSevice() throws Exception {
		mockMvc.perform(get("/api/review/search")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
			
	}
	
	@Test
	public void testSeviceFilterByReviewDate() throws Exception {
		mockMvc.perform(get("/api/review/search?review_date=2018-02-26")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
			
			
	}
	
	@Test
	public void testSeviceFilterByRatings() throws Exception {
		mockMvc.perform(get("/api/review/search?rating=4")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
			
	}
	
	@Test
	public void testSeviceFilterByStoretype() throws Exception {
		mockMvc.perform(get("/api/review/search?store_type=GooglePlayStore")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
			
	}
}
