package com.gmv.retomicroservicios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmv.retomicroservicios.modelos.Entidad;


@Repository
public interface RepositorioEntidad extends JpaRepository<Entidad, Integer>{

}
