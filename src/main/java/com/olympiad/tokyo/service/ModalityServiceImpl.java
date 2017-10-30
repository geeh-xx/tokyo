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
	
	private Modality saveModality(Modality modality) {
		return modalityRepository.save(modality);
	}

	@Override
	public boolean existModality(String name) {
		return modalityRepository.existsByNameIgnoreCase(name);
	}

	@Override
	public Modality findModalityByName(String name) {
		return modalityRepository.findByNameIgnoreCase(name);
	}
	
	@Override
	public Modality saveOrReturnModaliy(Modality modality) {
		return existModality(modality.getName()) ? findModalityByName(modality.getName()) : saveModality(modality); 
	}


}
