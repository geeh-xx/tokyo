package com.olympiad.tokyo.layer;

import com.olympiad.tokyo.model.Modality;

public interface ModalityService {
	public Modality saveModality(Modality modality);
	public boolean existModaity(String name);
}
