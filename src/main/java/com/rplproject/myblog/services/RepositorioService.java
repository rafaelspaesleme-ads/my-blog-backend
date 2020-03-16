package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.RepositorioDTO;
import com.rplproject.myblog.entities.Branch;
import com.rplproject.myblog.entities.Colaborador;
import com.rplproject.myblog.entities.Repositorio;
import com.rplproject.myblog.repositories.RepositorioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RepositorioService {

    private final RepositorioRepository repositorioRepository;
    private final BranchService branchService;
    private final ColaboradorService colaboradorService;

    public RepositorioService(RepositorioRepository repositorioRepository, BranchService branchService, ColaboradorService colaboradorService) {
        this.repositorioRepository = repositorioRepository;
        this.branchService = branchService;
        this.colaboradorService = colaboradorService;
    }

    public Optional<RepositorioDTO> findById(Long id){
        Repositorio repositorio = repositorioRepository.findById(id).orElse(null);
        return Optional.of(buildRepositorioDTO(Objects.requireNonNull(repositorio)));
    }

    public Page<RepositorioDTO> findByActive(Boolean active, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Repositorio> repositorios = repositorioRepository.findAllByActive(active, pageRequest);
        return repositorios.map(this::buildRepositorioDTO);
    }

    public Optional<RepositorioDTO> save(RepositorioDTO repositorioDTO){
        Repositorio repositorioDefinition;
        Repositorio buildRepositorio = buildRepositorio(repositorioDTO);
        Repositorio repositorio = repositorioRepository.save(buildRepositorio);
        List<Branch> branches = branchService.saveAll(repositorio);
        List<Colaborador> colaboradors = colaboradorService.saveAll(repositorio);
        Optional<Repositorio> repositorioUpdate = repositorioRepository.findById(repositorio.getId());
        repositorioDefinition = repositorioUpdate
                .map(value -> repositorioRepository.save(buildRepositorioUpdate(value, branches, colaboradors)))
                .orElseGet(() -> repositorioRepository.save(repositorio));
        return Optional.of(buildRepositorioDTO(repositorioDefinition));
    }

    public Optional<RepositorioDTO> disable(RepositorioDTO repositorioDTO, Long id){
        Optional<RepositorioDTO> repositorio = findById(id);
        repositorio.ifPresent(art -> repositorioRepository.save(buildRepositorio(repositorioDTO)));
        return repositorio;
    }

    public Boolean delete(Long id){
        Optional<RepositorioDTO> byId = findById(id);
        byId.ifPresent(repositorioDTO -> repositorioRepository.deleteById(id));
        Optional<RepositorioDTO> newById = findById(id);
        return !newById.isPresent();
    }

    public List<RepositorioDTO> findAll() {
        List<Repositorio> repositorios = repositorioRepository.findAll();
        List<RepositorioDTO> repositorioDTOS = new ArrayList<>();
        repositorios.forEach(repositorio -> repositorioDTOS.add(buildRepositorioDTO(repositorio)));
        return repositorioDTOS;
    }

    protected Repositorio buildRepositorio(RepositorioDTO repositorioDTO){
        return Repositorio.RepositorioBuilder.aRepositorio()
                .withId(repositorioDTO.getId())
                .withTitle(repositorioDTO.getTitle())
                .withDescription(repositorioDTO.getDescription())
                .withBranches(repositorioDTO.getBranches())
                .withCommitsNumber(repositorioDTO.getCommitsNumber())
                .withReleasesNumber(repositorioDTO.getReleasesNumber())
                .withContributors(repositorioDTO.getContributors())
                .withUrlRepository(repositorioDTO.getUrlRepository())
                .withDomainGit(repositorioDTO.getDomainGit())
                .withActive(repositorioDTO.getActive())
                .withUsernameGit(repositorioDTO.getUsernameGit())
                .withProgrammingLanguage(repositorioDTO.getProgrammingLanguage())
                .withDatePost(LocalDateTime.now())
                .build();
    }

    protected Repositorio buildRepositorioUpdate(Repositorio repositorio, List<Branch> branches, List<Colaborador> colaboradors){
        return Repositorio.RepositorioBuilder.aRepositorio()
                .withId(repositorio.getId())
                .withTitle(repositorio.getTitle())
                .withDescription(repositorio.getDescription())
                .withBranches(branches)
                .withCommitsNumber(repositorio.getCommitsNumber())
                .withReleasesNumber(repositorio.getReleasesNumber())
                .withContributors(colaboradors)
                .withUrlRepository(repositorio.getUrlRepository())
                .withDomainGit(repositorio.getDomainGit())
                .withActive(repositorio.getActive())
                .withUsernameGit(repositorio.getUsernameGit())
                .withProgrammingLanguage(repositorio.getProgrammingLanguage())
                .withDatePost(LocalDateTime.now())
                .build();
    }

    protected RepositorioDTO buildRepositorioDTO(Repositorio repositorio){
        return RepositorioDTO.RepositorioDTOBuilder.aRepositorioDTO()
                .withId(repositorio.getId())
                .withTitle(repositorio.getTitle())
                .withDescription(repositorio.getDescription())
                .withBranches(repositorio.getBranches())
                .withCommitsNumber(repositorio.getCommitsNumber())
                .withReleasesNumber(repositorio.getReleasesNumber())
                .withContributors(repositorio.getContributors())
                .withUrlRepository(repositorio.getUrlRepository())
                .withDomainGit(repositorio.getDomainGit())
                .withActive(repositorio.getActive())
                .withUsernameGit(repositorio.getUsernameGit())
                .withProgrammingLanguage(repositorio.getProgrammingLanguage())
                .withDatePost(repositorio.getDatePost())
                .build();
    }
}
