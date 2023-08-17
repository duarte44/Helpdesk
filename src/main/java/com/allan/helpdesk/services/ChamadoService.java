package com.allan.helpdesk.services;

import com.allan.helpdesk.domain.Chamado;
import com.allan.helpdesk.repositories.ChamadoRepository;
import com.allan.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findByid(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID: " + id));
    }


}
