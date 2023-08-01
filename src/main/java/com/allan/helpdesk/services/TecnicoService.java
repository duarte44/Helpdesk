package com.allan.helpdesk.services;

import com.allan.helpdesk.domain.Tecnico;
import com.allan.helpdesk.domain.dtos.TecnicoDTO;
import com.allan.helpdesk.repositories.TecnicoRepository;
import com.allan.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }
}
