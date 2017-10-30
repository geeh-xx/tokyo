package com.olympiad.tokyo.layer;

import com.olympiad.tokyo.model.Modality;

public interface ModalityService {
	public boolean existModality(String name);
	public Modality saveOrReturnModaliy(Modality modality);
	public Modality findModalityByName(String name);
}
