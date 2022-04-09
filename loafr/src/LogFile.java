
import java.util.ArrayList;

public class LogFile {
	private String filepath;
	private ArrayList<LogEntry> logEntryList;
	
	public LogFile(String filepath) {
		this.filepath = filepath;
		this.logEntryList = new ArrayList<>();
	}
	
	public LogEntry addLogEntry(String[] rowData) {
		LogEntry newEntry = addBloodSensorEntry(rowData);
		
		return newEntry;	}
	
	public LogEntry addBloodSensorEntry(String [] rowData) {
		String logType = rowData[0];
		String timestamp = rowData[1];
		String eventType = rowData[2];
		String deviceID = rowData[3];
		String eventMessage = rowData[4];
		String sugarLevel = rowData[5];
		
		LogEntry newEntry = new LogEntry(logType, timestamp, eventType, deviceID, eventMessage, sugarLevel);
		this.logEntryList.add(newEntry);
		
		return newEntry;
		
	}
	
	public int setFilter(Operation f) {
		
		int logEntryCount = this.logEntryList.size();
		
		if(f.getOpColumn().equals("sugarLevel")) {
			for(int i = 0; i < logEntryCount; i++) {
				
				if(this.logEntryList.get(i).getSugarLevel() != f.getFilterValue()) {
					this.logEntryList.get(i).setSugarLevelFilter(true);
				}
			}
			
			return 1;
		}
		
		else {    //invalid opColumn name
			System.out.println("Invalid column name");
			
			return 0;
		}
	}
		

	
	public void printLogFile() {
		int count = this.logEntryList.size();
		
		for(int i = 0; i < count; i++) {
			System.out.print(this.logEntryList.get(i));
		}
		
		return;
	}
	
	public void printUnfilteredEntries() {
		int count = this.logEntryList.size();
		
		for(int i = 0; i < count; i++) {
			boolean entryIsFiltered = this.logEntryList.get(i).getSugarLevelFilter();
			
			if(!entryIsFiltered) {
				System.out.print(this.logEntryList.get(i));
			}
		}
		
		return;
	}
	

}
