package beaconReadInput;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "..\\..\\resources\\sample.xlsx";
		String result = "" ;

		if(fileName.contains(".xls")) {
			ExcelReader exelreader = new ExcelReader(fileName);
			result = exelreader.readFile();
		}
		
		else if(fileName.contains(".txt")) {
			TextReader txtreader = new TextReader(fileName);
			result = txtreader.readFile();
		}
		
		else {
			result = "Please enter valid file type" ;
		}
		
		System.out.println(result);
	}

}
