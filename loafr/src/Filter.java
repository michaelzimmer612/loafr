
public class Filter extends Operation {
	
	private int filterValue;
	private boolean filterIncludes;
	private boolean bySugarLevel = false;

	// Initialize filter values and parent class
	public Filter(String opColumn, int filterValue, boolean filterIncludes) {

		super(opColumn);
		this.filterValue = filterValue;
		this.filterIncludes = filterIncludes;

		switch(opColumn) {
		case "sugarLevel": this.bySugarLevel = true;
		
		}
	}

	
	// Returns filterValue
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



