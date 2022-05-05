
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 


public class LogEntry {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	//private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
	private String logFileType;
	private LocalDateTime timestamp;
	private String eventType;
	private String deviceID;
	private String eventMessage;
	private boolean timestampIsFiltered = false;
	private boolean eventTypeIsFiltered = false;
	private boolean deviceIDIsFiltered = false;
	private boolean eventMessageIsFiltered = false;
	
	
	public LogEntry(String logFileType, String timestamp, String eventType, String deviceID, 
					String eventMessage) {
		//System.out.println(timestamp);
		
		
		this.logFileType = logFileType;
		this.timestamp = LocalDateTime.parse(timestamp, dtf);
		this.eventType = eventType;
		this.deviceID = deviceID;
		this.eventMessage = eventMessage;	
	}
	
	
	public void setTimestampFilter(boolean b) {
		this.timestampIsFiltered = b;
	}
	
	public boolean getTimestampFilter() {
		return this.timestampIsFiltered;
	}
	
	
	public void setEventTypeFilter(boolean b) {
		this.eventTypeIsFiltered = b;
	}
	
	public boolean getEventTypeFilter() {
		return this.eventTypeIsFiltered;
	}
	
	public void setDeviceIDFilter(boolean b) {
		this.deviceIDIsFiltered = b;
	}
	
	public boolean getDeviceIDFilter() {
		return this.deviceIDIsFiltered;
	}
	
	public void setEventMessageFilter(boolean b) {
		this.eventMessageIsFiltered = b;
	}
	
	public boolean getEventMessageFilter() {
		return this.eventMessageIsFiltered;
	}
	

	public String toString() {
		String s = this.logFileType + ", " + this.timestamp + ", " + this.eventType + ", " ;
		s = s + this.deviceID  + ", " + this.eventMessage;
		
		return s;
	}
	
	public String getLogFileType() {
		return this.logFileType;
	}
}
