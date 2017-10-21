package com.gmv.retomicroservicios.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmv.retomicroservicios.modelos.Entidad;
import com.gmv.retomicroservicios.repositorios.RepositorioEntidad;

@Service
public class ServicioEntidadImpl implements ServicioEntidad{
	@Autowired
	private RepositorioEntidad repositorioEntidad;

	public List<Entidad> findAll() {
		return this.repositorioEntidad.findAll();
	}

	public Entidad findById(Integer id) {
		return this.repositorioEntidad.getOne(id); // Quizás debería usarse findOne(id) de CrudRepository
	}

	public Entidad save(Entidad e) {
		return repositorioEntidad.save(e);
	}

	public void deleteEntidad(Entidad e) {
		this.repositorioEntidad.delete(e);
	}

	

}
