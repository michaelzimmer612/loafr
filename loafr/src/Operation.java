
public class Operation {
	private int timestamp;
	// Column to Filter by
	private String opColumn;

	// Booleans to hold which column is being filtered
	//private boolean isActive = false;
	//private boolean bySugarLevel = false;
	//private boolean byInsulinDose = false;
	private boolean byTimeStamp = false;
	private boolean byEventType = false;
	private boolean byDeviceID = false;
	private boolean byEventMessage = false;
	//private boolean byErrorFlag = false;

	
	
	public Operation(String opColumn) {
		this.opColumn = opColumn;

		// Set boolean for filtered column to True
		switch(opColumn) {
		case "timestamp": this.byTimeStamp = true;
		break;
		case "eventtype": this.byEventType = true;
		break;
		case "deviceid": this.byDeviceID = true;
		break;
		case "byEventMessage": this.byEventMessage = true;
		
		}
	}

	
	public String getOpColumn() {
		
		return this.opColumn;
	}

	
	// Returns timestamp
	int getTimeStamp(){
		
		return timestamp;
	}
}


/*
public class Operation {
	
	private int timestamp;
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
*/



