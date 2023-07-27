package com.allan.helpdesk.domain.repositories;

import com.allan.helpdesk.domain.Pessoa;
import com.allan.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {


}
