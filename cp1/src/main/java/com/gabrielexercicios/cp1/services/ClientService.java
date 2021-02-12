package com.gabrielexercicios.cp1.services;

import com.gabrielexercicios.cp1.dtos.ClientDTO;
import com.gabrielexercicios.cp1.entities.Client;
import com.gabrielexercicios.cp1.repositories.ClientRepository;
import com.gabrielexercicios.cp1.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(ClientDTO::new);
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client id not found"));
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDTO) {
		Client client = new Client();
		copyDtoToEntity(client, clientDTO);
		client.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
		client = repository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDTO) {
		try {
			Client client = repository.getOne(id);
			copyDtoToEntity(client, clientDTO);
			client = repository.save(client);
			return new ClientDTO(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Client id not found");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Client id not found");
		}
	}

	private void copyDtoToEntity(Client client, ClientDTO clientDTO) {
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setIncome(clientDTO.getIncome());
		client.setBirthDate(clientDTO.getBirthDate());
		client.setChildren(clientDTO.getChildren());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client = repository.findByCpf(username);

		if(client == null) {
			logger.warn("Cpf not found: " + username);
			throw new UsernameNotFoundException("Client not found");
		}

		logger.info("Client found: " + username);
		return client;
	}
}
