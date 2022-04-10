
public class BloodSensorLogEntry extends LogEntry {
	private int sugarLevel;
	private boolean sugarLevelIsFiltered = false;
	
	public BloodSensorLogEntry(String logFileType, String timestamp, String eventType, String deviceID, 
			String eventMessage, String sugarLevel) {
		
		super(logFileType,timestamp, eventType, deviceID, eventMessage);
		this.sugarLevel = Integer.parseInt(sugarLevel);
	}
	
	
	public int getSugarLevel() {
		return this.sugarLevel;
	}
	
	
	public boolean getSugarLevelFilter() {
		return this.sugarLevelIsFiltered;
	}
	
	
	public void setSugarLevelFilter(boolean b) {
		this.sugarLevelIsFiltered = b;
	}
	
	
	public String toString() {
		String s = super.toString() + ", " + this.sugarLevel;
		
		return s;
	}
	
}
