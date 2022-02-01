package com.stackinsat.test.presentation;


import com.stackinsat.test.domain.DomainPersonneMapper;
import com.stackinsat.test.dto.PersonneDto;
import com.stackinsat.test.dto.PersonneDtoMapper;
import com.stackinsat.test.service.PersonneService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personnes")
@Api(value="person Controller")
public class PersonneController {

    private PersonneService personneService;

   @GetMapping()
   public List<PersonneDto> findAll(){
        return personneService.findAll().stream().map(DomainPersonneMapper::toPersonneDto).collect(Collectors.toList());
   }


    public PersonneController(PersonneService personneService){
        this.personneService = personneService;
    }
    @PostMapping(
            value = "", consumes = "application/json", produces = "application/json")
    public PersonneDto createPersonne(@RequestBody PersonneDto personneDto) {
        return DomainPersonneMapper.toPersonneDto(personneService.creerPersonne(PersonneDtoMapper.toDomain(personneDto)));
    }
}
