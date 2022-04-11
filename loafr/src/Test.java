
public class Test {

	public static void main(String[] args) {
		
		
		
		
		System.out.println("Begining unit tests");
		System.out.println();
		
		System.out.println("Beginning Analyzer Class Unit Tests");
		//create analyzer for test data
		AnalyzerTest testAnalyzer = new AnalyzerTest();
		
		testAnalyzer.runTests();
		System.out.println("Completed Analyzer Class Unit Tests");
		System.out.println("");
		
		System.out.println("Beginning LogFile Class Unit Tests");
		
		LogFileTest testLogFile = new LogFileTest("testFilePath");
		testLogFile.runTests();
		
		System.out.println("Completed LogFile Class Unit Tests");
		
		System.out.println("Beginning Blood Sensor LogEntry Class Unit Tests");
		String logType = "bs";
		String timestamp = "2020/10/01 03:12:10";
		String eventType = "success";
		String deviceID = "BS001";
		String eventMessage = "success: blood sugar is 15";
	    String sugarLevel="15";
		BloodSensorLogEntryTest testBSLE = new BloodSensorLogEntryTest(logType, timestamp, eventType, deviceID, eventMessage, sugarLevel);
		testBSLE.runTests();
		
		System.out.println("Completed Blood Sensor LogEntry Class Unit Tests");
		
		System.out.println("Beginning Operation Class Unit Tests");
		
		OperationTest testOperation = new OperationTest("timestamp");
		testOperation.runTests();
		
		System.out.println("Completed Operation Class Unit Tests");
		
		
		System.out.println("Beginning Filter Class Unit Tests");
		FilterTest testFilter = new FilterTest("timestamp",11,false);
		testFilter.runTests();
		
		System.out.println("Completed Filter Class Unit Tests");
		
		System.out.println();
		System.out.println("Unit tests complete");
		System.out.println();
		
		
		
		//below are the methods that execute the end to end test scenario
		
		//create new analyzer object to hold log file data and allow for operations ot be performed
		Analyzer a = new Analyzer();
		
		//import log file from csv and display contents
		System.out.println("Original Data:");
		a.addLogFile("testdata2.csv");
		a.printAnalyzerData();
		System.out.println();
		
		System.out.println("Original Data with Unfiltered print function:");
		a.printUnfilteredData();
		System.out.println();
		
		//apply a filter to imported data based on sugar level and display results
		System.out.println("Filtered for rows with sugarlevel != 15 :");
		a.addOperation("filter", "sugarLevel", 15, false);
		a.printUnfilteredData();
		System.out.println();
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel != 5 :");
		a.addOperation("filter", "sugarLevel", 5, false);
		a.printUnfilteredData();
		System.out.println();
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel = 350 :");
		a.addOperation("filter", "sugarLevel", 350, true);
		a.printUnfilteredData();
		System.out.println();
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel = 5 :");
		a.addOperation("filter", "sugarLevel", 5, true);
		a.printUnfilteredData();
		System.out.println();
		
		
		
	}
}
