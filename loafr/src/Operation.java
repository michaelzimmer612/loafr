

public class Operation {
	
	private String opColumn;
	private int filterValue;
	private boolean filterIncludes;
	private boolean bySugarLevel = false;
	
	public Operation(String opColumn, int filterValue, boolean filterIncludes) {
		if(opColumn.equals("sugarLevel")) {
			this.bySugarLevel = true;
		}
		
		this.opColumn = opColumn;
		this.filterValue = filterValue;
		this.filterIncludes = filterIncludes;
		
	}
	
	public String getOpColumn() {
		return this.opColumn;
	}
	
	public int getFilterValue() {
		return this.filterValue;
	}
	
	public boolean getFilterIncludes() {
		return this.filterIncludes;
	}
	
	public boolean getBySugarLevel() {
		return this.bySugarLevel;
	}
	

}
