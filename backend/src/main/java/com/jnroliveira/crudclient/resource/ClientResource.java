package com.jnroliveira.crudclient.resource;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnroliveira.crudclient.entity.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@GetMapping
	ResponseEntity<List<Client>> findAll() {
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Júnior", "00100200304", 1050.65, Instant.now(), 1));
		list.add(new Client(2L, "Maria", "00100200305", 2055.80, Instant.now(), 3));
		return ResponseEntity.ok().body(list);
	}

}
