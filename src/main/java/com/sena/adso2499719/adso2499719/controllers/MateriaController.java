package com.sena.adso2499719.adso2499719.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.interfaces.IMateriaService;

@RequestMapping("api/materia")
@RestController
public class MateriaController {

	@Autowired
    private IMateriaService service;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.ok(service.getAll());	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(service.getByid(id));

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Materia materia){
		try {
			return ResponseEntity.ok(service.save(materia));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Materia materia){
		try {
			service.update(id, materia);
			return ResponseEntity.ok("Registro actualizado");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok("Registro eliminado");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}	
	}
	
}
