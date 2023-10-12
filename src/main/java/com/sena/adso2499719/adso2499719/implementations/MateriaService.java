package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.interfaces.IMateriaService;
import com.sena.adso2499719.adso2499719.repositories.MateriaRepository;

@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private MateriaRepository repository;
	
	@Override
	public List<Materia> getAll() {
		return repository.findAll();
	}

	@Override
	public Materia getByid(Long id) throws Exception {
		Optional<Materia> materiaOpcional = repository.findById(id);
		if (materiaOpcional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return materiaOpcional.get();
	}

	@Override
	public Materia save(Materia materia) {
		materia.setCreatedAt(LocalDateTime.now());
		return repository.save(materia);
	}

	@Override
	public void update(Long id, Materia materia) throws Exception {
		Optional<Materia> materiaDBOpt = repository.findById(id);
		if (materiaDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Materia materiaDB = materiaDBOpt.get();
		materiaDB.setNombre(materia.getNombre());
		materiaDB.setUpdateAt(LocalDateTime.now());
		
		repository.save(materiaDB);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Materia> materiaDBOpt = repository.findById(id);
		if (materiaDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
	}

}
