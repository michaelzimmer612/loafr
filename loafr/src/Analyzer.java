//test

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


// Traced to Section 4.2.5 of Design Document v1.4
public class Analyzer {
	private ArrayList<LogFile> logFileList;
	private ArrayList<Operation> operationList; 
	
	
	public Analyzer() {
		this.logFileList = new ArrayList<>();
		this.operationList = new ArrayList<>();
		
	}
	
	// Purpose: Calls Helper function LogFile.readLogFile to read in csv logfile and return populated Logfile.
    //          Adds populated Logfile to logFileList.
	// Parameters:
	//   1. filepath:String - filepath for csv of log data
	// Pre-conditions:
	//   1. filepath has a valid csv with comma delimited fields
	// Post-conditions:
	//   1. Analyzer object has a logfile object with log data added to logFileList.
	// Returns: LogFile object
	public LogFile addLogFile(String filepath) {
		LogFile log = LogFile.readLogFile(filepath);
		
		this.logFileList.add(log);
		
		return log;
	}
	
	
	// Purpose: Add a filter, sort, or search to operationList and perform operation
	// Parameters:
	//   1. opColumn:String - Name of column on which the operation is performed
	//   2. filterValue:int - Filter value
	//   3. filterIncludes:boolean - If true, rows = filterValue included in filtered output. If false, excluded
	// Pre-conditions:
	//   1. logFileList in Analyzer is non-empty
	// Post-conditions:
	//   1. Operation added to logFileList and log entries booleans updated per operation
	// Returns: 1 (success), 0 (failure)
	public int addOperation(String op, String opColumn, int filterValue, boolean filterIncludes) {
		
		int logFileCount = this.logFileList.size();
		if(logFileCount == 0) {
			System.out.println("No data to perform operation");
			return 0;
		}
		
		String opColumnLow = opColumn.toLowerCase();
		
		if(!(opColumnLow.equals("sugarlevel") || opColumnLow.equals("timestamp") || opColumnLow.equals("eventType") ||
				opColumnLow.equals("deviceid") || opColumnLow.equals("eventmessage"))) {
			
			System.out.println("Invalid column name");
			
			return 0;
		}
		
		if(op.equals("filter")) {
			Filter newOp = new Filter(opColumnLow, filterValue, filterIncludes);
			
			for(int i = 0; i < logFileCount; i++) {
				this.logFileList.get(i).setFilter(newOp);
			}
			
			this.operationList.add(newOp);
			
			return 1;
		}
		
		return 0;

	}
	

	
	public void printAnalyzerData() {
		int count = this.logFileList.size();
		
		for(int i = 0; i < count; i++) {
			this.logFileList.get(i).printLogFile();
		}
		
		return;
	}
	
	public void printUnfilteredData() {
		int count = this.logFileList.size();
		
		for(int i = 0; i < count; i++) {
			this.logFileList.get(i).printUnfilteredEntries();
		}
		
		return;
	}
	
	
	public int count() {
		int numLogFiles = getLogFileList().size();
		int count = 0;
		
		for(int i = 0; i < numLogFiles; i++) {
			LogFile currentLogFile = getLogFileList().get(i);
			ArrayList<BloodSensorLogEntry> logEntries = currentLogFile.getLogEntryList();
			int numLogEntries = currentLogFile.size();
			
			for(int j = 0; j < numLogEntries; j++) {
				BloodSensorLogEntry currentEntry = logEntries.get(j);
				boolean deviceIDBool = currentEntry.getDeviceIDFilter();
				boolean timestampBool = currentEntry.getTimestampFilter();
				boolean eventTypeBool = currentEntry.getEventTypeFilter();
				boolean eventMessageBool = currentEntry.getEventMessageFilter();
				boolean sugarLevelBool = currentEntry.getSugarLevelFilter();
				
				if(!(deviceIDBool || timestampBool || eventTypeBool || eventMessageBool || sugarLevelBool)) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	
	public ArrayList<LogFile> getLogFileList() {
		return this.logFileList;
	}
	
	public ArrayList<Operation> getOperationList(){
		return this.operationList;
	}
	

}
	
	
