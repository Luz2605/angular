package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.entities.Aprendiz;



@Repository
public interface IAprendizService {

	List<Aprendiz> getAll();

	Aprendiz getByid(Long id) throws Exception;
	
	Aprendiz save(Aprendiz aprendiz);
	
	void update(Long id, Aprendiz aprendiz) throws Exception;

	void delete(Long id) throws Exception;
}
