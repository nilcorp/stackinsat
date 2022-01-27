package com.stackinsat.test.dto;

import com.stackinsat.test.model.Test;

public class TestDtoMapper {

    public static Test toModel(TestDto testDto){
        Test test = new Test();
        test.setId(testDto.id);
        test.setLibele(testDto.libelle);
        return test;
    }
}
