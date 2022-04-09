//Analyzer class

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Analyzer {
	private ArrayList<LogFile> logFileList;
	private ArrayList<Operation> operationList; 
	
	
	public Analyzer() {
		this.logFileList = new ArrayList<>();
		this.operationList = new ArrayList<>();
		
	}
	
	public LogFile addLogFile(String filepath) throws FileNotFoundException {
		LogFile log = new LogFile(filepath);
		
		File f = new File(filepath);
		Scanner s = new Scanner(f);
		s.useDelimiter(",");
		
		s.nextLine();    //skip line of column name
		String[] currentRow = new String[6];
		
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < 6; i++) {
				currentRow[i] = s.next();
			}
			
			log.addLogEntry(currentRow);
		}
		
		this.logFileList.add(log);
		
		s.close();
		
		return log;
	}
	
	
	
	public int addOperation(String op, String opColumn, int filterValue, boolean filterIncludes) {
		Operation newOp = new Operation(opColumn, filterValue, filterIncludes);
		
		if(op.equals("filter")) {
			Operation f = new Operation(opColumn, filterValue, filterIncludes);
			
			int logFileCount = this.logFileList.size();
			
			for(int i = 0; i < logFileCount; i++) {
				this.logFileList.get(i).setFilter(f);

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
	

}
	
	
