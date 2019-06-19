package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SheetParsingResult<T> {

    int amountSuccess = 0;
    private List<RowParsingResult<T>> failures;
    private List<RowParsingResult<T>> toProcess;

    public SheetParsingResult() {
        this.failures = new ArrayList<>();
        this.toProcess = new ArrayList<>();
    }

    public void plusOneFailure(RowParsingResult<T> result) {
        this.failures.add(result);
    }

    public List<RowWithRownumber<T>> getElementsToProcess() {
        return toProcess.stream()
                        .map(RowParsingResult::getDataRow)
                        .collect(Collectors.toList());

    }

    public void plusOneSuccess(RowParsingResult<T> result) {
        toProcess.add(result);
    }
}
