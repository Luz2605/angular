package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.entities.Materia;

@Repository
public interface IMateriaService {

	List<Materia> getAll();

	Materia getByid(Long id) throws Exception;
	
	Materia save(Materia materia);
	
	void update(Long id, Materia materia) throws Exception;

	void delete(Long id) throws Exception;
}
