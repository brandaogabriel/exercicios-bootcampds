package com.gabrielexercicios.cp1.repositories;

import com.gabrielexercicios.cp1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
