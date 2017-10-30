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

import com.olympiad.tokyo.model.Local;
import com.olympiad.tokyo.repository.LocalRepository;
import com.olympiad.tokyo.service.LocalServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class LocalTest {

	@Mock
	private LocalRepository localRepository;
	
	@InjectMocks
	private LocalServiceImpl localServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveOrReturnLocal(){
		Local local = new Local("Mineirão");
		when(localServiceImpl.saveOrReturnLocal(local)).thenReturn(local);
		Local result = localServiceImpl.saveOrReturnLocal(local);
		assertEquals("Mineirão", result.getName());
	}
	
	@Test
	public void testFindlocalByName(){
		Local local = new Local("Kokuritsu Kasumigaoka");
		when(localServiceImpl.findLocalByName("Kokuritsu Kasumigaoka")).thenReturn(local);
		Local result = localServiceImpl.findLocalByName(local.getName());
		assertEquals("Kokuritsu Kasumigaoka", result.getName());
	}
	
}
