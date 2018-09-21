package beaconReadInput;

public class Transformation {

	private String columnName;
    private Integer startIndex;
    private Integer finishIndex;
    private String FIDColumnName;
    private Integer TCid ;
    
	public Transformation(Integer startIndex, Integer finishIndex, String columnName,
			Integer tCid,  String fIDColumnName) {
		super();
		this.columnName = columnName;
		this.startIndex = startIndex;
		this.finishIndex = finishIndex;
		FIDColumnName = fIDColumnName;
		TCid = tCid;
	}

	public String getColumnName() {
		return columnName;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public Integer getFinishIndex() {
		return finishIndex;
	}

	public String getFIDColumnName() {
		return FIDColumnName;
	}

	public Integer getTCid() {
		return TCid;
	}

		
	
}
