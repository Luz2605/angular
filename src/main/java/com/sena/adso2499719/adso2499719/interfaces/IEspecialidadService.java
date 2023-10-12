package com.sena.adso2499719.adso2499719.interfaces;
import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.Especialidad;

public interface IEspecialidadService {

	
	List<Especialidad> getAll();
	
	Especialidad getByid(Long id) throws Exception;
	
	Especialidad save(Especialidad especialidad);
	
	void update(Long id, Especialidad especialidad) throws Exception;
	
	void delete(Long id) throws Exception;
}