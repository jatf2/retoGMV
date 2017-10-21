package com.gmv.retomicroservicios.servicios;

import java.util.List;

import com.gmv.retomicroservicios.modelos.Entidad;

public interface ServicioEntidad {

	List<Entidad> findAll();

	Entidad findById(Integer id);

	Entidad save(Entidad e);

	void deleteEntidad(Entidad e);



}
