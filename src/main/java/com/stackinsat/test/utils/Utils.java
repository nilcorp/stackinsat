package com.stackinsat.test.utils;

import com.stackinsat.test.exception.BusinessException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static LocalDate convertStingToLocalDate(String date){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, formatter);
        }catch (Exception e){
            throw new BusinessException("Convertion date erreur");
        }
    }
}
