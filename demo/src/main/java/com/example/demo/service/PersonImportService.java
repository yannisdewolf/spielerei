package com.example.demo.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

public class PersonImportService extends AbstractBatchImportService<PersonRecord> {
    @Override
    protected void handleData(List<RowWithRownumber<PersonRecord>> elementsToProcess, BatchImportResult batchImportResult) {

        System.out.println("saving " + elementsToProcess + " in the database, but only if they are validated");

    }

    @Override
    protected ExcelRowMapper<PersonRecord> getRowMapper() {
        return new ExcelRowMapper<>() {
            @Override
            public RowParsingResult<PersonRecord> map(Row row) {
                Cell firstName = row.getCell(0);
                Cell lastName = row.getCell(1);
                Cell gender = row.getCell(2);
                PersonRecord rowData = new PersonRecord(
                        firstName.getStringCellValue(),
                        lastName.getStringCellValue(),
                        gender.getStringCellValue()
                );
                return new RowParsingResult<>(new RowWithRownumber<>(rowData, row.getRowNum()), RowParsingOutcome.success());
            }
        };
    }
}
