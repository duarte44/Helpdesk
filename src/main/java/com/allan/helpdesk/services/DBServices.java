package com.allan.helpdesk.services;

import com.allan.helpdesk.domain.Chamado;
import com.allan.helpdesk.domain.Cliente;
import com.allan.helpdesk.domain.Tecnico;
import com.allan.helpdesk.domain.enums.Perfil;
import com.allan.helpdesk.domain.enums.Prioridade;
import com.allan.helpdesk.domain.enums.Status;
import com.allan.helpdesk.repositories.ChamadoRepository;
import com.allan.helpdesk.repositories.ClienteRepository;
import com.allan.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBServices {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB(){

        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "57558540097", "valdir@gmail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Allan D", "55566640097", "allanD@gmail.com", "123");
        tec2.addPerfil(Perfil.ADMIN);


        Cliente cli1 = new Cliente(null, "Linus Turvus","07470203028", "Linus@gmail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));

    }
}
