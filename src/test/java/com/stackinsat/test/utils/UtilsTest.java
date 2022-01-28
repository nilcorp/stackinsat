package com.stackinsat.test.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class UtilsTest {

    @Test
    public void convertStingToLocalDateTest(){
        LocalDate test = Utils.convertStingToLocalDate("29/04/1980");
        Assertions.assertTrue(test.equals(LocalDate.of(1980,4,29)));
    }
}
