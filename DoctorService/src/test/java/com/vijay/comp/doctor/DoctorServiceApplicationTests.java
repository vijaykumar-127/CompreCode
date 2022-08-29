package com.vijay.comp.doctor;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.vijay.comp.doctor.entity.Doctor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceApplicationTests {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om=new ObjectMapper();
	
	@Before
	public void setUp() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	//@Test
	public void createDoctor() throws Exception {
		Doctor doctor=new Doctor();
		doctor.setDoctorName("vijay");
		doctor.setDoctorAge(35);
		doctor.setDoctorGender("Male");
		doctor.setDoctorSpecialization("Neuro");
		String jsonRequest=om.writeValueAsString(doctor);
		
		MvcResult result=mockMvc.perform(post("/home/doctors").content(jsonRequest).
				contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent=result.getResponse().getContentAsString();
		Response response=om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus()==Boolean.TRUE);
		
				
	}
	//@Test
	public void getAllDoctors() throws Exception {
		MvcResult result=mockMvc.perform(get("/home/doctors").contentType(MediaType.APPLICATION_JSON_VALUE)).
				andExpect(status().isOk()).andReturn();
		String resultContent=result.getResponse().getContentAsString();
		Response response=om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus()==Boolean.TRUE);
				
	}
	


}
