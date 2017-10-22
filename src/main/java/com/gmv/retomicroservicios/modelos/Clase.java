package com.gmv.retomicroservicios.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clase")
public class Clase {

    @Id
    @Column(name="clase_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
