package com.allan.helpdesk.repositories;

import com.allan.helpdesk.domain.Cliente;
import com.allan.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
