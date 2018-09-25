
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.lang.Object;
 import java.util.ArrayList;
 import java.util.Map;
 import java.util.HashMap;
 
 /*
  *
  * Beacon: Main Processing Class
  *
  */
 public class BeaconProcessor {
	
 
     public static void main(String a[]){
    	 String fileName = "D:\\Workspace\\BeaconPOI\\Resources\\sample.txt";
    	 String LayoutFileName="D:\\Workspace\\BeaconPOI\\Resources\\Book2.xlsx";
    	 
 		String result = "" ;
 		

 	/*	if(fileName.contains(".xls")) {
 			ExcelReader exelreader = new ExcelReader(fileName);
 			result = exelreader.readFile();
 		}*/
 		
 		if(fileName.contains(".txt")) {
 			TextReader txtreader = new TextReader(fileName);
 			result = txtreader.readFile();
 		}
 		
 		else {
 			result = "Please enter valid file type" ;
 		}
 		
 		System.out.println(result);
 		ExcelReader exelreader = new ExcelReader(LayoutFileName);
 		List<Transformation> tr=exelreader.readFile();
 		
 		TransformationContext tc= new TransformationContext("ADP",101,tr);
 		
 		 
 		 List <Map<String,String>> li=new ArrayList<>();
 		 int i,j;
 		 i=0;
 		 result=result.trim();
 		 boolean temp=true;
 		 while(temp==true)
 		 {
 			Map<String, String> transformedRecord = new HashMap<>();
 		  System.out.println(result+"is the results");
 		
 		 i=result.indexOf(" ");
 		 String s;
 		         if(i>=0)
 				  s=result.substring(0,i);
 		         else
 		         { s=result.substring(0);
 		            temp=false;
 		         }
 				
 				 for(Transformation t:tr)
 				 {
 					 int st=t.getStartIndex();
 					 System.out.println(st+" ");
 					 
 					 int fi=t.getFinishIndex();
 					System.out.println(fi+" ");
 					 
 					String fdcl=t.getColumnName();
 					System.out.println(fdcl+" ");
 					transformedRecord.put(fdcl, s.substring(st-1,fi));
 					
 					 
 				 }
 				 System.out.println(transformedRecord+" ia the required map");
 				 li.add(transformedRecord);
 				 result=result.substring(i+1);
 				result=result.trim();
 				//result=result.substring();
 				
 		 } 
 		 System.out.println(li+"is the required List");
 				 
 		//System.out.println(s+" hello World"); 		
 		 
 		
 	   
 		List<JSONObject> jsonObj = new ArrayList<JSONObject>();

 		for(Map<String, String> data : li) {
 		    JSONObject obj = new JSONObject(data);
 		    jsonObj.add(obj);
 		}

 		JSONArray test = new JSONArray(jsonObj);

 		System.out.println(test.toString());
 		
 		//FileWriter file = new FileWriter("");
 	
     
     }
         

 }