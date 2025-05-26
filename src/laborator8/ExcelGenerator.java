package laborator8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ExcelGenerator {
    public static void main(String[] args) throws IOException {
        // 1. Structura de date
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[] {"Prenume", "Nume", "N1", "N2", "N3", "N4", "MAX", "AVG"});
        data.put("2", new Object[] {"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[] {"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[] {"Brian", "Schultz", 7, 6, 8, 9});

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rezultate");

        // 2. Stiluri
        CellStyle boldGreen = workbook.createCellStyle();
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);
        boldGreen.setFont(boldFont);
        boldGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        boldGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle yellowFill = workbook.createCellStyle();
        yellowFill.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowFill.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rowNum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum);
            Object[] objArr = entry.getValue();

            for (int col = 0; col < objArr.length; col++) {
                Cell cell = row.createCell(col);

                if (objArr[col] instanceof String) {
                    cell.setCellValue((String) objArr[col]);
                } else if (objArr[col] instanceof Integer) {
                    cell.setCellValue((Integer) objArr[col]);
                }

                // Stiluri
                if (rowNum == 0) {
                    cell.setCellStyle(boldGreen);
                } else if (col == 6 || col == 7) {
                    cell.setCellStyle(yellowFill);
                }
            }

            // 3. Formule
            if (rowNum > 0) {
                int excelRow = rowNum + 1;
                row.createCell(6).setCellFormula("MAX(D" + excelRow + ":G" + excelRow + ")");
                row.createCell(7).setCellFormula("AVERAGE(D" + excelRow + ":G" + excelRow + ")");
                row.getCell(6).setCellStyle(yellowFill);
                row.getCell(7).setCellStyle(yellowFill);
            }

            rowNum++;
        }

        // Auto-size columns
        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        // 4. Salvare
        try (FileOutputStream out = new FileOutputStream("output8.xlsx")) {
            workbook.write(out);
        }

        workbook.close();
        System.out.println("Fisierul output8.xlsx a fost generat cu succes.");
    }
}

