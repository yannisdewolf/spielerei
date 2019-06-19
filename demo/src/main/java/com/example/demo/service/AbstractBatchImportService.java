package com.example.demo.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBatchImportService<T> {

    private final Logger logger = LoggerFactory.getLogger(AbstractBatchImportService.class);

    public BatchImportResult importData(InputStream is) {
        SheetProcessingContext sheetProcessingContext = new SheetProcessingContext();
        BatchImportResult<T> batchImportResult = new BatchImportResult<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            //validate workbook: amount of sheets, columns defined

            SheetParsingResult<T> sheetParsingResult = parseFile(workbook.getSheetAt(0));
            batchImportResult.addSheetParsingResult(sheetParsingResult);

            handleData(sheetParsingResult.getElementsToProcess(), batchImportResult);


        } catch (Exception ex) {
            batchImportResult.error(ex);
            logger.error("something went wrong",ex);
        } finally {
            return batchImportResult;
        }
    }

    protected abstract void handleData(List<RowWithRownumber<T>> elementsToProcess, BatchImportResult batchImportResult);

    private SheetParsingResult<T> parseFile(XSSFSheet sheet) {
        SheetParsingResult<T> sheetParsingResult = new SheetParsingResult<>();

        ExcelRowMapper<T> rowMapper = getRowMapper();

        Iterator<Row> rowIterator = sheet.rowIterator();
        if(!rowIterator.hasNext()) {
            System.out.println("no rows???");
        }
        while (rowIterator.hasNext()) {
            RowParsingResult<T> result = rowMapper.map(rowIterator.next());
            if (result.isSuccess()) {
                sheetParsingResult.plusOneSuccess(result);
            } else {
                sheetParsingResult.plusOneFailure(result);
            }
        }

        return sheetParsingResult;
    }

    protected abstract ExcelRowMapper<T> getRowMapper();

}
