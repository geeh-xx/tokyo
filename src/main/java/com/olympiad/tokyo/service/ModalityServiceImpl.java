package com.olympiad.tokyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olympiad.tokyo.layer.ModalityService;
import com.olympiad.tokyo.model.Modality;
import com.olympiad.tokyo.repository.ModalityRepository;

@Service("modalityService")
public class ModalityServiceImpl implements ModalityService{

	@Autowired
	private ModalityRepository modalityRepository;
	
	@Override
	public Modality saveModality(Modality modality) {
		return modalityRepository.save(modality);
	}

	@Override
	public boolean existModaity(String name) {
		return modalityRepository.existsByName(name);
	}

}
