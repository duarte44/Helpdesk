package com.allan.helpdesk.domain.repositories;

import com.allan.helpdesk.domain.Chamado;
import com.allan.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {


}
