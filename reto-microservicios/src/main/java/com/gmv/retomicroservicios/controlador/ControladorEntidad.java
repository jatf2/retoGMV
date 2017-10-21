package com.gmv.retomicroservicios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gmv.retomicroservicios.modelos.Entidad;
import com.gmv.retomicroservicios.servicios.ServicioEntidad;

@RestController
public class ControladorEntidad {
	@Autowired
	private ServicioEntidad servicioEntidad;
	
	// Crear entidad
	@RequestMapping(value="/entidades", method = RequestMethod.POST)
	public ResponseEntity<Entidad> add(@RequestBody Entidad input) {
		
		Entidad e = new Entidad();
		e.setId(input.getId());
		e.setNombre(input.getNombre());
		e.setDescripcion(input.getDescripcion());
		e.setClase(input.getClase());
		this.servicioEntidad.save(e);
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}
		
	// Editar entidad
	@RequestMapping(value="/entidades/{id}", method=RequestMethod.PUT)
	public Entidad updateEntidad(@PathVariable("id") Integer id, @RequestBody Entidad e) {
		Entidad fromDB = this.servicioEntidad.findById(id);
		if(fromDB != null) {
			e.setId(fromDB.getId());
			return this.servicioEntidad.save(e);
		}
		return null;
	}	
	
	// Ver entidad
	@RequestMapping(value="/entidades/{id}", method=RequestMethod.GET)
	public ResponseEntity<Entidad> findById(@PathVariable("id") Integer id){
		Entidad e = this.servicioEntidad.findById(id);
		if(e!=null)
			return ResponseEntity.status(HttpStatus.OK).body(e);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}	
	
	// Listar entidades
	@RequestMapping(value="/entidades", method=RequestMethod.GET)
	public List<Entidad> findAll(){
		return this.servicioEntidad.findAll();
	}
			
	// Borrar entidad
	@RequestMapping(value="/entidades/{id}", method=RequestMethod.DELETE) 
	public ResponseEntity<Entidad> deleteEntidad(@PathVariable("id") Integer id) {
		Entidad fromDB = this.servicioEntidad.findById(id);
		if(fromDB != null) {
			this.servicioEntidad.deleteEntidad(fromDB);
			return ResponseEntity.status(HttpStatus.OK).body(fromDB);			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
	}
}
