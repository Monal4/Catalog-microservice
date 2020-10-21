package com.music.CatalogService.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.CatalogService.Exceptions.ServiceException;
import com.music.CatalogService.domain.Download;
import com.music.CatalogService.domain.Track;
import com.music.CatalogService.service.CatalogService;
import com.music.CatalogService.service.data.DownloadData;
import com.music.CatalogService.ui.controllers.CatalogController;

//@ActiveProfiles("integrationtest")
@RunWith(SpringRunner.class)
@WebMvcTest(CatalogController.class)
class CatalogControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private CatalogService catalogService;
	
	@Test
	void testGetAllDownloads() throws Exception {
		
//		Set<DownloadData> set = new HashSet<>();
//		
//		Download download = new Download();
//		download.setDownloadDate(new Date());
//		download.setEmailAddress("rupapara.mr@gmail.com");
//		download.setDownloadId(1);
//		
//		DownloadData d = new DownloadData(download);
//		
//		set.add(d);
//		
//		Mockito.when(catalogService.getListofDownloads()).thenReturn(set);
//		
//		String uri = "/getAllDownloads";
//		
//		RequestBuilder builder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockmvc.perform(builder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//				
//		String json = toJSON(set);
		
//		assertThat(json).isEqualTo(response.getContentAsString());
//		mockmvc.perform(MockMvcRequestBuilders.get("/getAllDownloads"))
//			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.isEmptyOrNullString()));
	}
	
//	private String toJSON(Object object) throws JsonProcessingException {
//		ObjectMapper o = new ObjectMapper();
//		return o.writeValueAsString(object);
//	}

//	@Test
//	void testGetCart() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSaveCartInfo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCatInfo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProductById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateCart() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProductByCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRemoveItemFromCart() {
//		fail("Not yet implemented");
//	}

}
