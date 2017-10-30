package com.olympiad.tokyo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.olympiad.tokyo.model.Modality;
import com.olympiad.tokyo.repository.ModalityRepository;
import com.olympiad.tokyo.service.ModalityServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ModalityTest {

	@Mock
	private ModalityRepository modalityRepository;
	
	@InjectMocks
	private ModalityServiceImpl modalityServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testSaveOrReturnModality(){
		Modality modality = new Modality("Soccer");
		when(modalityServiceImpl.saveOrReturnModaliy(modality)).thenReturn(modality);
		Modality result = modalityServiceImpl.saveOrReturnModaliy(modality);
		assertEquals("Soccer", result.getName());
		
	}
	
	@Test
	public void testFindModalityByName(){
		Modality modality = new Modality("Swimming");
		when(modalityServiceImpl.findModalityByName("Swimming")).thenReturn(modality);
		Modality result = modalityServiceImpl.findModalityByName(modality.getName());
		assertEquals("Swimming", result.getName());
		
	}
	
}
