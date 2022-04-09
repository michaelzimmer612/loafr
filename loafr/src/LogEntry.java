
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 


public class LogEntry {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	
	private String logFileType;
	private LocalDateTime timestamp;
	private String eventType;
	private String deviceID;
	private String eventMessage;
	private int sugarLevel;
	private boolean timestampIsFiltered = false;
	private boolean eventTypeIsFiltered = false;
	private boolean deviceIDIsFiltered = false;
	private boolean eventMessageIsFiltered = false;
	private boolean sugarLevelIsFiltered = false;
	
	public LogEntry(String logFileType, String timestamp, String eventType, String deviceID, 
					String eventMessage, String sugarLevel) {
		

		this.logFileType = logFileType;
		this.timestamp = LocalDateTime.parse(timestamp, dtf);
		this.eventType = eventType;
		this.deviceID = deviceID;
		this.eventMessage = eventMessage;
		this.sugarLevel = Integer.parseInt(sugarLevel);
		
	}
	
	public int getSugarLevel() {
		return this.sugarLevel;
	}
	
	public boolean getSugarLevelFilter() {
		return this.sugarLevelIsFiltered;
	}
	
	
	public void setTimestampFilter(boolean b) {
		this.timestampIsFiltered = b;
	}
	
	public void setEventTypeFilter(boolean b) {
		this.eventTypeIsFiltered = b;
	}
	
	public void setDeviceIDFilter(boolean b) {
		this.deviceIDIsFiltered = b;
	}
	
	public void setEventMessageFilter(boolean b) {
		this.eventMessageIsFiltered = b;
	}
	
	public void setSugarLevelFilter(boolean b) {
		this.sugarLevelIsFiltered = b;
	}
	
	public String toString() {
		String s = this.logFileType + ", " + this.timestamp + ", " + this.eventType + ", " ;
		s = s + this.deviceID  + ", " + this.eventMessage + ", " + this.sugarLevel;
		
		return s;
	}
	
}
