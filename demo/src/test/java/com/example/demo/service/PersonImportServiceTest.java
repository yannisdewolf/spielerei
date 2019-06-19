package com.example.demo.service;

import org.junit.Test;

import java.io.InputStream;


public class PersonImportServiceTest {

    @Test
    public void runtEst() {
        InputStream resourceAsStream = this.getClass()
                                           .getClassLoader()
                                           .getResourceAsStream("data.xlsx");

        BatchImportResult batchImportResult = new PersonImportService().importData(resourceAsStream);


    }

}
