package com.olympiad.tokyo.layer;

import com.olympiad.tokyo.model.Local;

public interface LocalService {
	public boolean existLocal(String name);
	public Local saveOrReturnLocal(Local local);
	public Local findLocalByName(String name);
}
