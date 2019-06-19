package com.example.demo.service;

import java.util.StringJoiner;

public class RowWithRownumber<T> {

    private T rowData;
    private Integer rowNumber;

    public RowWithRownumber(T rowData, Integer rowNumber) {
        this.rowData = rowData;
        this.rowNumber = rowNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RowWithRownumber.class.getSimpleName() + "[", "]")
                .add("rowData=" + rowData)
                .add("rowNumber=" + rowNumber)
                .toString();
    }
}
