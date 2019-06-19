package com.example.demo.service;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelRowMapper<T> {
    RowParsingResult<T> map(Row row) ;
}
