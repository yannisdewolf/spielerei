package com.example.demo.service;

import java.util.StringJoiner;

public class RowParsingResult<T> {

    private RowWithRownumber<T> dataRow;
    private RowParsingOutcome rowParsingOutcome;

    public RowParsingResult(RowWithRownumber<T> dataRow, RowParsingOutcome rowParsingOutcome) {
        this.dataRow = dataRow;
        this.rowParsingOutcome = rowParsingOutcome;
    }

    public boolean isSuccess() {
        return rowParsingOutcome.isSuccess();
    }

    public RowWithRownumber<T> getDataRow() {
        return dataRow;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RowParsingResult.class.getSimpleName() + "[", "]")
                .add("dataRow=" + dataRow)
                .add("rowParsingOutcome=" + rowParsingOutcome)
                .toString();
    }
}
