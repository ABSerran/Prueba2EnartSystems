package com.enartsystems.Prueba2API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enartsystems.Prueba2API.model.Client;
import com.enartsystems.Prueba2API.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List <Client> clientList(){
		return repository.findAll();
	}
	
	public void saveClient(Client client) {
		repository.save(client);
	}
	
	public Client getClient(Integer id) {
		return repository.findById(id).get();
	}
	
	public void deleteClient(Integer id) {
		repository.deleteById(id);
	}

}
