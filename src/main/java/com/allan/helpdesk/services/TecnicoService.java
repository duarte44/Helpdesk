package com.allan.helpdesk.services;

import com.allan.helpdesk.domain.Pessoa;
import com.allan.helpdesk.domain.Tecnico;
import com.allan.helpdesk.domain.dtos.TecnicoDTO;
import com.allan.helpdesk.repositories.PessoaRepository;
import com.allan.helpdesk.repositories.TecnicoRepository;
import com.allan.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.allan.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return repository.save(newObj);


    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {
        Optional<Pessoa> obj =pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }
    }

    public Tecnico update(Integer id, TecnicoDTO objDto) {
        objDto.setId(id);
        Tecnico oldObj = findById(id);
        validaPorCpfEEmail(objDto);
        oldObj = new Tecnico(objDto);
        return repository.save(oldObj);
    }
}
