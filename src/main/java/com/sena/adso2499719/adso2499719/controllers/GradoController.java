package com.sena.adso2499719.adso2499719.controllers;

import java.util.List;

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

import com.sena.adso2499719.adso2499719.dto.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.interfaces.IGradoService;

@RequestMapping("api/grado")
@RestController
public class GradoController {

	@Autowired
	private IGradoService service;
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Grado>>> getAll() {
		
		ApiResponseDto<List<Grado>> respuesta = new ApiResponseDto<List<Grado>>();
		try {
			
			respuesta.setStatus(true);
			respuesta.setMessage("datos obtenidos");
			respuesta.setData(service.getAll());

			return ResponseEntity.ok(respuesta);		
		} catch (Exception e) {
			respuesta.setStatus(false);
			respuesta.setMessage("datos obtenidos"); 
			
			return ResponseEntity.internalServerError().body(respuesta);
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
	public ResponseEntity<?> save(@RequestBody Grado grado){
		try {
			return ResponseEntity.ok(service.save(grado));

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Grado grado){
		try {
			service.update(id, grado);
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
