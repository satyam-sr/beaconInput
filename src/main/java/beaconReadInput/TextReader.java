package beaconReadInput;

import java.io.* ;

public class TextReader {
	
	String fileName ;
	
	TextReader(String fileName){
		this.fileName = fileName ;
	}

	public String readFile(){
		
		String result = "";
        try {
        	BufferedReader br = null;
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
               result += (line + "\n");
            }
            return result ;
        }
        catch (IOException e) {
            return "Error Reading file " + fileName;
        }
	}
}
