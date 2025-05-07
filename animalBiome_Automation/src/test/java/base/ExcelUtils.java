package base;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;
    private static String excelFilePath;

    
    
    public static String UniquePetName(String baseName) throws IOException {
        File counterFile = new File("pet_name_counter.txt");
        Map<String, Integer> counterMap = new HashMap<>();

        if (counterFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(counterFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        counterMap.put(parts[0], Integer.parseInt(parts[1]));
                    }
                }
            }
        }

        int count = counterMap.getOrDefault(baseName, 0) + 1;
        counterMap.put(baseName, count);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(counterFile))) {
            for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }

        return baseName + count;
    }
    
    public static void loadExcelFile(String filePath, String sheetName) throws IOException {
        excelFilePath = filePath; 
        FileInputStream file = new FileInputStream(new File(filePath));
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        file.close();
    }

    
    public static String getCellValue(Row row, int columnIndex) {
        if (row == null) return "";
        Cell cell = row.getCell(columnIndex);
        if (cell == null) return "";
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString();
    }

    public static String getNextSample(String columnName) throws IOException {
        validateSheetLoaded();

        int columnIndex = getColumnIndex(columnName);

       
        CellStyle highlightStyle = workbook.createCellStyle();
        highlightStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        highlightStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Cell sampleCell = row.getCell(columnIndex);
            if (sampleCell == null || sampleCell.getCellType() == CellType.BLANK) continue;

            
            CellStyle currentStyle = sampleCell.getCellStyle();
            if (currentStyle != null &&
                currentStyle.getFillForegroundColor() == IndexedColors.YELLOW.getIndex() &&
                currentStyle.getFillPattern() == FillPatternType.SOLID_FOREGROUND) {
                continue;
            }

            String sampleID = getCellValue(row, columnIndex);

            sampleCell.setCellStyle(highlightStyle);  

            saveExcelFile();
            return sampleID;
        }
        
        

        return null; 
    }


   
    public static void addPetNameToSpeciesColumn(String speciesColumn, String petName) throws IOException {
        if (speciesColumn == null || speciesColumn.isEmpty()) {
            throw new IllegalArgumentException("Species column cannot be null or empty.");
        }
        
        if (petName == null || petName.isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be null or empty.");
        }

        
        validateSheetLoaded();

        
        int columnIndex = getColumnIndex(speciesColumn);

        
        int insertRowIndex = -1;
        boolean foundEmptyCell = false;
        
        
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            
            String cellValue = getCellValue(row, columnIndex);
            if (cellValue.isEmpty()) {
                insertRowIndex = i;
                foundEmptyCell = true;
                break;
            }
        }

        
        if (!foundEmptyCell) { 
            insertRowIndex = sheet.getLastRowNum() + 1;
        }

       
        Row row = sheet.getRow(insertRowIndex);
        if (row == null) {
            row = sheet.createRow(insertRowIndex);
        }

     
        Cell petCell = row.createCell(columnIndex);
        petCell.setCellValue(petName);

        
        saveExcelFile();
        
        System.out.println("Pet name added successfully: " + petName);
    }

    public static String getAvailablePetName(String speciesColumn) throws IOException {
       

        int columnIndex = getSpeciesColumnIndex(speciesColumn);
        for (int i = 1; i <= ExcelUtils.sheet.getLastRowNum(); i++) {
            Row row = ExcelUtils.sheet.getRow(i);
            if (row == null) continue;

            String petName = ExcelUtils.getCellValue(row, columnIndex);
            if (!petName.isEmpty()) {
                return petName;
            }
        }
        return null; 
    }

    
    private static int getSpeciesColumnIndex(String speciesColumn) {
        Row headerRow = ExcelUtils.sheet.getRow(0);
        for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
            if (ExcelUtils.getCellValue(headerRow, i).equalsIgnoreCase(speciesColumn)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Species column not found: " + speciesColumn);
    }

    
    public static void deletePetNameFromSpeciesColumn(String speciesColumn, String petName) throws IOException {
        validateSheetLoaded();

        int columnIndex = getColumnIndex(speciesColumn);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            String currentPetName = getCellValue(row, columnIndex);
            if (currentPetName.equalsIgnoreCase(petName)) {
                row.getCell(columnIndex).setCellValue("");
                saveExcelFile();
                return;
            }
        }
    }

  
    private static void saveExcelFile() throws IOException {
        FileOutputStream outFile = new FileOutputStream(excelFilePath);
        workbook.write(outFile);
        outFile.close();
    }

    
    private static int getColumnIndex(String columnName) {
        Row headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
            if (getCellValue(headerRow, i).equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Column not found: " + columnName);
    }

  
    private static void validateSheetLoaded() {
        if (sheet == null) {
            throw new IllegalStateException("Excel file and sheet must be loaded first. Call loadExcelFile().");
        }
    }
}



