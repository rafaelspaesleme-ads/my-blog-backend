package com.rplproject.myblog.services;

import com.rplproject.myblog.entities.Branch;
import com.rplproject.myblog.entities.Repositorio;
import com.rplproject.myblog.repositories.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    protected List<Branch> saveAll(Repositorio repositorio){
        List<Branch> branches = new ArrayList<>();
        repositorio.getBranches().forEach(branch -> {
            branches.add(buildBranch(branch, repositorio));
        });
        return branchRepository.saveAll(branches);
    }

    protected Branch buildBranch(Branch branch, Repositorio repositorio){
        return Branch.BranchBuilder.aBranch()
                .withId(branch.getId())
                .withName(branch.getName())
                .withRepositorio(repositorio)
                .withActive(branch.getActive())
                .build();
    }

}
