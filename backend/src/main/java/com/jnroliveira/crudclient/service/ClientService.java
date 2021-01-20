package com.jnroliveira.crudclient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jnroliveira.crudclient.dto.ClientDTO;
import com.jnroliveira.crudclient.entity.Client;
import com.jnroliveira.crudclient.repository.ClientRepository;
import com.jnroliveira.crudclient.service.exception.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Client not found"));
		return new ClientDTO(entity);
	}
}
