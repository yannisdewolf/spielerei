package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

public class BatchImportResult<T> {

    List<RowWithRownumber<T>> errors;

    BatchImportResult() {
        errors = new ArrayList<>();
    }

    public  void error(Exception ex) {
        System.out.println("error occured");
    }

    public void addErrorWhileProcessing(RowWithRownumber<T> rowWithRownumber) {
        errors.add(rowWithRownumber);
    }

    /**
     * how many went wrong from parsing (invalid or incomplete data, ...)
     * @param sheetParsingResult
     */
    public void addSheetParsingResult(SheetParsingResult<T> sheetParsingResult) {

    }
}
