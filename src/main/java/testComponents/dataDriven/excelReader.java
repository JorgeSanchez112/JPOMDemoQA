package testComponents.dataDriven;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class excelReader {
    public Object[][] readTestData(String sheetName) throws IOException {
        FileInputStream file = new FileInputStream("src\\main\\java\\ExcelFile\\DDTDemoQA." + "xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        List<Object[]> dataList = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1); // Skip header row
            int colCount = row.getLastCellNum();
            Object[] rowData = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                rowData[j] = getCellValue(cell);
            }
            dataList.add(rowData);
        }

        workbook.close();
        file.close();

        return dataList.toArray(new Object[0][]);
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            case _NONE:
                return "";
            default:
                return cell.getStringCellValue();
        }
    }
}
