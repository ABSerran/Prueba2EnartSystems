package com.enartsystems.Prueba2API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enartsystems.Prueba2API.model.Client;

public interface ClientRepository extends JpaRepository <Client, Integer>{

}
