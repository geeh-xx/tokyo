package com.olympiad.tokyo.layer;

import com.olympiad.tokyo.exception.CompetitonException;
import com.olympiad.tokyo.model.Modality;

public interface ModalityService {
	public boolean existModality(String name);
	public Modality saveOrReturnModaliy(Modality modality);
	public Modality saveOrReturnModaliy(String modality) throws CompetitonException;
	public Modality findModalityByName(String name);
}
