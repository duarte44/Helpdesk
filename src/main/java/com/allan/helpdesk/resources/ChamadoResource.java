package com.allan.helpdesk.resources;


import com.allan.helpdesk.domain.Chamado;
import com.allan.helpdesk.domain.dtos.ChamadoDTO;
import com.allan.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

    @Autowired
    private ChamadoService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<ChamadoDTO> findByid(@PathVariable Integer id){
        Chamado obj = service.findByid(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }

}
