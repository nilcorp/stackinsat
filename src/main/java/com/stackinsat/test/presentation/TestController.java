package com.stackinsat.test.presentation;

import com.stackinsat.test.dto.TestDto;
import com.stackinsat.test.dto.TestDtoMapper;
import com.stackinsat.test.model.Test;
import com.stackinsat.test.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    private TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping
    public ResponseEntity<List<Test>> findAll(){
        return new ResponseEntity<>(testService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public Test findbyId(@PathVariable("id") Long id){
        return testService.findById(id);
    }

    @PostMapping(
            value = "", consumes = "application/json", produces = "application/json")
    public TestDto createPerson(@RequestBody TestDto testDto) {
        testService.create(TestDtoMapper.toModel(testDto));
        return testDto;
    }
}
