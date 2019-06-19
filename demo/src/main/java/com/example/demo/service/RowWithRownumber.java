package com.example.demo.service;

public class RowWithRownumber<T> {

    private T rowData;
    private Integer rowNumber;

    public RowWithRownumber(T rowData, Integer rowNumber) {
        this.rowData = rowData;
        this.rowNumber = rowNumber;
    }
}
