package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Producto;

@Repository

	public interface interfacepro extends JpaRepository<Producto, Integer>{

	
		
}
