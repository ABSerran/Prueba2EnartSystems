package com.enartsystems.Prueba2API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enartsystems.Prueba2API.model.Client;
import com.enartsystems.Prueba2API.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping("/clients")
	public List<Client> clientList() {
		return service.clientList();
	}

	@GetMapping("clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Integer id) {

		try {
			Client client = service.getClient(id);
			return new ResponseEntity<Client>(client, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("/clients")
	public void saveClient(@RequestBody Client client) {
		service.saveClient(client);

	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<?> updateClient(@RequestBody Client client, @PathVariable Integer id) {
		try {
			Client existingClient = service.getClient(id);
			existingClient.setName(client.getName());
			existingClient.setSurname(client.getSurname());
			service.saveClient(client);
			return new ResponseEntity<Client>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable Integer id) {
		try {
			service.deleteClient(id);
			return new ResponseEntity<Client>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

	}
}
