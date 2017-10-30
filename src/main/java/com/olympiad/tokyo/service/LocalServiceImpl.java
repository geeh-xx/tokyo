package com.olympiad.tokyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olympiad.tokyo.layer.LocalService;
import com.olympiad.tokyo.model.Local;
import com.olympiad.tokyo.repository.LocalRepository;

@Service("localService")
public class LocalServiceImpl implements LocalService{

	@Autowired
	private LocalRepository localRepository;
	
	private Local saveLocal(Local local) {
		return localRepository.save(local);
	}
	
	@Override
	public boolean existLocal(String name) {
		return localRepository.existsByNameIgnoreCase(name);
	}

	@Override
	public Local findLocalByName(String name) {
		return localRepository.findByNameIgnoreCase(name);
	}
	
	@Override
	public Local saveOrReturnLocal(Local local) {
		return existLocal(local.getName()) ? findLocalByName(local.getName()) : saveLocal(local); 
	}

}
