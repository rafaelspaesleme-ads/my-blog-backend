package com.rplproject.myblog.services;

import com.rplproject.myblog.entities.Colaborador;
import com.rplproject.myblog.entities.Repositorio;
import com.rplproject.myblog.repositories.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    protected List<Colaborador> saveAll(Repositorio repositorio){
        List<Colaborador> colaboradors = new ArrayList<>();
        repositorio.getContributors().forEach(colaborador -> {
            colaboradors.add(buildColaborador(colaborador, repositorio));
        });
        return colaboradorRepository.saveAll(colaboradors);
    }

    protected Colaborador buildColaborador(Colaborador colaborador, Repositorio repositorio){
        return Colaborador.ColaboradorBuilder.aColaborador()
                .withId(colaborador.getId())
                .withUsernameGit(colaborador.getUsernameGit())
                .withRepositorio(repositorio)
                .withActive(colaborador.getActive())
                .build();
    }
}
