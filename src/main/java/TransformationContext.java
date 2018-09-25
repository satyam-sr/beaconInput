import java.util.List;
class TransformationContext {
    private String vendorName;
    private Integer vendorId;
    private List<Transformation> transformations;
	public TransformationContext(String vendorName, Integer vendorId, List<Transformation> transformations) {
		super();
		this.vendorName = vendorName;
		this.vendorId = vendorId;
		this.transformations = transformations;
	}
	public String getVendorName() {
		return vendorName;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public List<Transformation> getTransformations() {
		return transformations;
	}
	 
	
    
   
   
}