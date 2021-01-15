package com.gabrielexercicios.cp1.services;

import com.gabrielexercicios.cp1.dtos.ClientDTO;
import com.gabrielexercicios.cp1.entities.Client;
import com.gabrielexercicios.cp1.repositories.ClientRepository;
import com.gabrielexercicios.cp1.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(ClientDTO::new);
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client id not found."));
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDTO) {
		Client client = new Client();
		copyDtoToEntity(client, clientDTO);
		client = repository.save(client);
		return new ClientDTO(client);
	}

	private void copyDtoToEntity(Client client, ClientDTO clientDTO) {
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setIncome(clientDTO.getIncome());
		client.setBirthDate(clientDTO.getBirthDate());
		client.setChildren(clientDTO.getChildren());
	}

}
