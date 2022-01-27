package com.stackinsat.test.service;

import com.stackinsat.test.exception.BusinessException;
import com.stackinsat.test.exception.NoDataFoundException;
import com.stackinsat.test.model.Test;
import com.stackinsat.test.repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class TestService {

    Logger logger = LoggerFactory.getLogger(TestService.class);

    private TestRepository testRepository;

    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public List<Test> findAll(){
        return testRepository.findAll();
    }

    public Test findById(Long id){
        Optional<Test> optionalTest = testRepository.findById(id);
        if(optionalTest.isPresent()){
            return optionalTest.get();
        }else{
            throw new NoDataFoundException();
        }
    }

    public void create(Test test ){
        try {
            logger.info("Creation !!!");
            testRepository.save(test);
        }catch(Exception e){
            throw new BusinessException("Create error");
        }

    }
}
