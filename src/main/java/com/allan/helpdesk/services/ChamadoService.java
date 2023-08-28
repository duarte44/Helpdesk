package com.allan.helpdesk.services;

import com.allan.helpdesk.domain.Chamado;
import com.allan.helpdesk.domain.dtos.ChamadoDTO;
import com.allan.helpdesk.repositories.ChamadoRepository;
import com.allan.helpdesk.services.exceptions.ObjectNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findByid(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID: " + id));
    }


    public List<Chamado> findAll() {
        return repository.findAll();
    }
}
