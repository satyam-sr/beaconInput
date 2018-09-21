package beaconReadInput;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	String fileName ;
	
	ExcelReader(String fileName){
		this.fileName = fileName ;
	}
	
	public List<Transformation> readFile() {

		String result = "" ;
		
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            System.out.println("dfefeerer");
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //System.out.println(sheet);
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            
            List<Transformation> TranformationContext = new ArrayList<Transformation>() ;
            rowIterator.next();
            while (rowIterator.hasNext()) {
            	System.out.println("inside row");
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                
                Transformation context = null ;
                int startIndex = -1,finishIndex  = -1,TCid = -1;
                String FidColumnName = "", columnName = "" ; 
                int i = 0;
                while (cellIterator.hasNext()) {
                 	System.out.println("zRow "+i);
                     Cell cell = cellIterator.next();
                     //System.out.println(cell.getCellType());
                    // Check the cell type and format accordingly
                    
                    switch (i) {
                    	case 0:
                    		startIndex = (int)cell.getNumericCellValue();
                    		break ;
                    		
                    	case 1:
                    		finishIndex = (int)cell.getNumericCellValue();
                    		break ;
                    		
                    	case 2:
                    		columnName = cell.getStringCellValue();
                    		break ;
                    		
                    	case 3:
                    		TCid = (int)cell.getNumericCellValue();
                    		break ;
                    		
                    	case 4:
                    		FidColumnName = cell.getStringCellValue();
                    		break ;
                    		
                    	default:
                    		break ;
                    }
                    i++;
                    
                }
                System.out.println("hegewgrjewgr");
                context = new Transformation(startIndex,finishIndex,columnName,TCid,FidColumnName);
                System.out.println("answer "+context.getColumnName()+" "+TCid+" "+finishIndex+" "+FidColumnName+" "+startIndex);
                TranformationContext.add(context);
              
            }
            file.close();
            return  TranformationContext ;
        }
        catch (Exception e) {
           return null ;
        }
	}

}
