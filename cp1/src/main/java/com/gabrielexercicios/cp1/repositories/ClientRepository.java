package com.gabrielexercicios.cp1.repositories;

import com.gabrielexercicios.cp1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByCpf(String cpf);
}
