import java.util.List;
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
        System.out.println("Start Processing");
        
        
        // Start Hardcoding the input data
        String[] inputRecords = {"asdadwerwre2342424","xvcxvxvc535435","jshflkshnslknfslkf94598437539"};
        
        // Configure the TransformationContext
        TransformationContext transformationContext = new TransformationContext();
        
        // Configure the transformation for every record
        transformationContext.addTransformation(new Transformation());
        transformationContext.addTransformation(new Transformation());
        transformationContext.addTransformation(new Transformation());
        transformationContext.addTransformation(new Transformation());
        
        int totalRecords = inputRecords.length;
                
        List<Map<String,String>> outputRecords = new ArrayList<>();
        List<String> badRecords = new ArrayList<>();
        for(int count=0;count<totalRecords;count++){
            String inputData = inputRecords[count];
            System.out.println("Starting processing for record :: "+inputData);
            try{
                Map<String, String> transformedRecord = new HashMap<>();
                for(Transformation transformation:transformationContext.getTransformations()){
                    System.out.println("Processing for Column :: "+transformation);
                    transformedRecord.put("column"+count,"value"+count);
                }
                outputRecords.add(transformedRecord);
                System.out.println("Finished processing for record ");
            }catch(Exception exception){
                System.out.println("Error processing for record ");
                badRecords.add(inputData);
            }
        }        
        System.out.println("Finish Processing");
    }
}


/*
 * Class to store the TransformationContext configurations for input records
 *
 */
class TransformationContext {
    private String vendorName;
    private Integer vendorId;
    private List<Transformation> transformations;
    
    public void setVendorName(String vendorName){
        this.vendorName = vendorName;
    }
    
    public String getVendorName(){
        return this.vendorName;
    }
    
    public void addTransformation(Transformation transformation){
        if(this.transformations==null){
            this.transformations = new ArrayList<>();
        }
        this.transformations.add(transformation);
    }
    
    public List<Transformation> getTransformations(){        
        return this.transformations;
    }
    
    //...................
    // Continue the same getter/setter for the other properties of this class.
    //...................
}

/*
 * Class to store the Transformation configuration for columns
 *
 */
class Transformation {
    private String columnName;
    private Integer startIndex;
    private Integer finishIndex;
    private String FIDColumnName;
    
    //...................
    // Continue the same getter/setter for the other properties of this class.
    //...................
}