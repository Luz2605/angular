package com.sena.adso2499719.adso2499719.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dto.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadService;

@RestController
@RequestMapping("api/especialidad")
@CrossOrigin("http://localhost:4200")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService service;
	
	
	// status = Boolean
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Especialidad>>> getAll() {
		
		ApiResponseDto<List<Especialidad>> respuesta = new ApiResponseDto<List<Especialidad>>();
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
	public ResponseEntity<ApiResponseDto<Especialidad>> getById(@PathVariable Long id){
		try {
			
			service.getByid(id);
			return ResponseEntity.ok(new ApiResponseDto<Especialidad>("datos encontrados", true , service.getByid(id)));

		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Especialidad>(e.getMessage(), false, null));
		}
	}
	//Guardar
	@PostMapping
	public ResponseEntity<ApiResponseDto<Especialidad>> save(@RequestBody Especialidad especialidad){
		try {
			
			return ResponseEntity.ok(new ApiResponseDto<Especialidad>("Guardado", true, service.save(especialidad)));

		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Especialidad>(e.getMessage(),false, null));
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Especialidad>> update(@PathVariable Long id,@RequestBody Especialidad especialidad){
		try {
			service.update(id, especialidad);
			return ResponseEntity.ok(new ApiResponseDto<Especialidad>("Registro modficado", true, null));
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Especialidad>(e.getMessage(),false, null));
		}
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Especialidad>> delete(@PathVariable Long id){
		try {
			service.delete(id);
			
			return ResponseEntity.ok(new ApiResponseDto<Especialidad>("Registro eliminado", true, null));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Especialidad>(e.getMessage(), false, null));

		}
	
	}
}
