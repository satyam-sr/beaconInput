package beaconReadInput;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	String fileName ;
	
	ExcelReader(String fileName){
		this.fileName = fileName ;
	}
	
	public String readFile() {

		String result = "" ;
		
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
 
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
 
                while (cellIterator.hasNext()) {
                	
                     Cell cell = cellIterator.next();
                     System.out.println(cell.getCellType());
                    // Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                    case NUMERIC:
                        result += (cell.getNumericCellValue() + "\t");
                        break;
                    case STRING:
                        result += (cell.getStringCellValue() + "\t");
                        break;
                    }
                }
                result += "\n" ;
            }
            file.close();
            return  result ;
        }
        catch (Exception e) {
           return "Error reading file" + fileName;
        }
	}

}
