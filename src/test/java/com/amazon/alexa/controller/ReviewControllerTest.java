package com.amazon.alexa.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;
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
		mockMvc.perform(get("/api/review/search")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.[0].id", is(1)))
		.andExpect(jsonPath("$.[0].review_source", is("iTunes")))
		.andExpect(jsonPath("$.[1].review_source", is("GooglePlayStore")))
		.andExpect(jsonPath("$.[0].rating", is(4)))
		.andExpect(jsonPath("$.[1].rating", is(1)));
		
			
	}
	
	@Test
	public void testSeviceFilterByReviewDate() throws Exception {
		mockMvc.perform(get("/api/review/search?review_date=2018-01-12")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.[0].id", is(1)))
				.andExpect(jsonPath("$.[0].review_source", is("iTunes")))
				.andExpect(content().string(org.hamcrest.Matchers.containsString("2018-01-12")))
				.andExpect(jsonPath("$.*", hasSize(1)));
	}
	
	@Test
	public void testSeviceFilterByRatings() throws Exception {
		mockMvc.perform(get("/api/review/search?rating=4")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$.[0].id", is(1)))
				.andExpect(jsonPath("$.[0].id", is(1)))
				.andExpect(jsonPath("$.[0].rating", is(4)))
				.andExpect(jsonPath("$.*", hasSize(1)));
	}
	
	@Test
	public void testSeviceFilterByStoretype() throws Exception {
		mockMvc.perform(get("/api/review/search?store_type=GooglePlayStore")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$.[0].id", is(1)))
				.andExpect(jsonPath("$.[0].review_source", is("GooglePlayStore")))
				.andExpect(jsonPath("$.*", hasSize(1)))
				.andExpect(content().string(org.hamcrest.Matchers.containsString("iTunes")));
			
	}
}
