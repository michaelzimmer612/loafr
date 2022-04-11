
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

// Traced to Section 4.2.1 of Design Document v1.4
public class LogFile {
	private String filepath;
	private ArrayList<LogEntry> logEntryList;
	
	public LogFile(String filepath) {
		this.filepath = filepath;
		this.logEntryList = new ArrayList<>();
	}
	
	public LogEntry addLogEntry(String[] rowData) {
		String logType = rowData[0];
		String timestamp = rowData[1];
		String eventType = rowData[2];
		String deviceID = rowData[3];
		String eventMessage = rowData[4];

		
		if(rowData[0].equals("bs")) {
			String sugarLevel = rowData[5];
			//System.out.println(logType);
			//System.out.println(timestamp);
			//System.out.println(eventType);
			//System.out.println(deviceID);
			//System.out.println(eventMessage);
			//System.out.println(sugarLevel);
			
			BloodSensorLogEntry newEntry = new BloodSensorLogEntry(logType, timestamp, eventType, deviceID, eventMessage, sugarLevel);
			this.logEntryList.add(newEntry);
			
			return newEntry;
		}
		
		else {    //invalid log entry type
			System.out.println("Invalid log entry type");
			return null;
		}
	}
	
	
	// Purpose: Reads in csv logfile and returns populated Logfile.
	// Parameters:
	//   1. filepath:String - filepath for csv of log data
	// Pre-conditions:
	//   1. filepath has a valid csv with comma delimited fields
	// Post-conditions:
	//   1. Analyzer object has a logfile object with log data added to logFileList.
	// Returns: LogFile object
	public static LogFile readLogFile(String filepath) {

		LogFile log = new LogFile(filepath);

		try {
			File f = new File(filepath);
			Scanner s = new Scanner(f);
			
			s.useDelimiter("\\n");

			String current = s.next();         
			String[] currentRow;

			// Read in header data and get column count
			currentRow = current.split(",");
			int colCount = currentRow.length;

			// Create log entry for each row and add to LogFile
			while(s.hasNext()) {
				current = s.next();

				// Discard empty rows
				if(current.length() > 1) {
					currentRow = current.split(",", colCount);
					log.addLogEntry(currentRow);
				}
			}
			
			s.close();
			
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		return log;
	}
	
	// Purpose: Set attribute filter booleans in LogEntries based on parameters of Filter operation.
	// Parameters:
	//   1. op:Operation - Filter operation
	// Pre-conditions:
	//   1. None
	// Post-conditions:
	//   1. Attribute filter booleans for each Log Entry set based on parameters of Filter operation
	// Returns: 1(success), 0(failure)
	public int setFilter(Filter op) {
		
		int logEntryCount = this.logEntryList.size();
		
		if(op.getOpColumn().toLowerCase().equals("sugarlevel")) {
			int entrySugarLevel;
			int filterSugarLevel = op.getFilterValue();
			boolean filterIncludes = op.getFilterIncludes();
			
			
			for(int i = 0; i < logEntryCount; i++) {
				 entrySugarLevel = ((BloodSensorLogEntry)this.logEntryList.get(i)).getSugarLevel();
				
				// if filterIncludes = true, hide all entries with sugarLevel != filterSugarLevel
				if(filterIncludes && (entrySugarLevel != filterSugarLevel)) {
					((BloodSensorLogEntry)this.logEntryList.get(i)).setSugarLevelFilter(true);
				}
				
				// if filterIncludes = false, hide all entries with sugarLevel == filterSugarLevel
				else if(!filterIncludes && (entrySugarLevel == filterSugarLevel)) {
					((BloodSensorLogEntry)this.logEntryList.get(i)).setSugarLevelFilter(true);
				}
			}

			return 1;
		}
		
		else {    //invalid opColumn name
			System.out.println("Invalid column name");
			
			return 0;
		}
	}
	
	
	public int size() {
		
		return this.logEntryList.size();
	}
		

	
	public void printLogFile() {
		int count = this.logEntryList.size();
		
		for(int i = 0; i < count; i++) {
			System.out.print(this.logEntryList.get(i) + "\n");
		}
		
		return;
	}
	
	
	public void printUnfilteredEntries() {
		int count = this.logEntryList.size();
		
		for(int i = 0; i < count; i++) {
			boolean entryIsFiltered = ((BloodSensorLogEntry)this.logEntryList.get(i)).getSugarLevelFilter();
			
			if(!entryIsFiltered) {
				System.out.print(this.logEntryList.get(i) + "\n");
			}
		}
		
		return;
	}
	
	public ArrayList<LogEntry> getLogEntryList(){
		return this.logEntryList;
	}
	
	public String getFilePath(){
		return this.filepath;
	}
	
	
}
