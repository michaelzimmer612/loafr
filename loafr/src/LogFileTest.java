import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogFileTest extends LogFile  {

	

	public LogFileTest(String filepath) {
		super(filepath);
		// TODO Auto-generated constructor stub
	}

	@Test
	void testLogFile() {
		System.out.println("testing logfile creation");
		
		String thisClass = ""+this.getClass();
		//System.out.println(aClass);
		assert thisClass.equals("class Analyzer"): "failed to correctly construct logfile";
		assert this.getFilePath().equals("testFilePath");
		//fail("Not yet implemented");
		System.out.println("test passed");
	}

	@Test
	void testAddLogEntry() {
		//create new blood sensor log entry for testing
		System.out.println("testing  add log entry function");
		String logType = "bs";
		String timestamp = "2020/10/01 03:12:10";
		String eventType = "success";
		String deviceID = "BS001";
		String eventMessage = "success: blood sugar is 15";
	    String sugarLevel="15";
	    
	    String[] rowData = new String [] {logType,timestamp,eventType,deviceID,eventMessage,sugarLevel};
	    
	    this.addLogEntry(rowData);
		//String testEntry = "bs, 2020-10-01T03:12:10, success, BS001, success: blood sugar is 15, 15";
		BloodSensorLogEntry testEntry = new BloodSensorLogEntry(logType, timestamp, eventType, deviceID, eventMessage, sugarLevel);
		String entry = this.getLogEntryList().get(0).toString();
		String testEntryString = testEntry.toString();
		//compare created entry with imported entry
		assert testEntryString.equals(entry) : "log file data loaded incorrectly";
		System.out.println("test passed");
	}

	@Test
	void testReadLogFile() {
		System.out.println("testing log file read file function");
		String fileNameTestData = "testdata2.csv";
		this.readLogFile(fileNameTestData);
		assert this.size()==1 : "number of log files imported is incorrect";
		System.out.println("test passed");
	}

	@Test
	void testSetFilter() {
		System.out.println("testing log file size function");
		Filter testFilter = new Filter("not a column name",10, false);
		int a = this.setFilter(testFilter);
		assert a==0: "filter value incorrectly applied";
		//fail("Not yet implemented");
		System.out.println("test passed");
	}

	@Test
	void testSize() {
		System.out.println("testing log file size function");
		assert this.size()==1:"size function returned incorrect result";
		System.out.println("test passed");
	}

	

	
	public void runTests() {
		this.testLogFile();
		this.testAddLogEntry();
		this.testSetFilter();
		this.testSize();
		this.testReadLogFile();
	}

}
