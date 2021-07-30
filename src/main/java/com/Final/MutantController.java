package com.Final;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MutantController {

    @Autowired
    private MutantRepository repository;

    // Find
    @GetMapping("/mutants")
    List<Mutant> findAll() {
        return repository.findAll();
    }

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/mutants")
    boolean newMutant(@RequestBody Mutant newMutant) {
        try {
            MutantService service = new MutantService();
            boolean isMutant = service.validateMutantDna(newMutant.getDna());
            //boolean isMutant = service.MutantService(newMutant.getDna());

            if (isMutant) {
                repository.save(newMutant);
            }
            return isMutant;
        } catch (Exception e) {
            return false;
        }
    }
}
