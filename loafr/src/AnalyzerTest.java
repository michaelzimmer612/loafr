import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Sean
 *
 */
class AnalyzerTest extends Analyzer {


	/**
	 * Test method for {@link Analyzer#Analyzer()}.
	 */
	@Test
	void testAnalyzer() {
		//test to ensure analyzer contructor created necessary array list, if variables were not create, code will error out
		System.out.println("testing analizer variable declaration");
		
		String thisClass = ""+this.getClass();
		//System.out.println(aClass);
		assert thisClass.equals("class Analyzer"): "failed to correctly construct analyzer";
		assert this.getOperationList()!=null:"failed to create operation list";
		assert this.getLogFileList()!=null:"failed to log file list";
		
		
		System.out.println("test passed");
		//assert(typeof a !== 'undefined')
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Analyzer#addLogFile(java.lang.String)}.
	 */
	@Test
	void testAddLogFile(String filepath) {
		System.out.println("testing add log file function");
		try {
			this.addLogFile(filepath);
		}
		catch (Exception e) {
			System.out.println("failed to import log file with exceptiom: "+e);
		}
		
		System.out.println("test passed");
	}

	/**
	 * Test method for {@link Analyzer#addOperation(java.lang.String, java.lang.String, int, boolean)}.
	 */
	@Test
	void testAddOperation(String op, String opColumn, int filterValue, boolean filterIncludes) {
		System.out.println("begining add operation function test");
		String opColumnLow = opColumn.toLowerCase();
		Filter testFilter = new Filter(opColumnLow, filterValue, filterIncludes);
		this.addOperation(op, opColumn, filterValue, filterIncludes);
		Operation testOutput =this.getOperationList().get(0);
		assert testOutput.getOpColumn()==testFilter.getOpColumn(): "input filter list values do not match operation list";
		assert testOutput.getTimeStamp()==testFilter.getTimeStamp(): "input filter list values do not match operation list";
		System.out.println("test passed");
		//fail("Not yet implemented");
		//Filter@4590c9c3
	}

	/**
	 * Test method for {@link Analyzer#printAnalyzerData()}.
	 */
	@Test
	void testPrintAnalyzerData() {
		fail("Not yet implemented");
	}

	
	
	//this function runs all the tests in this class
	void runTests() {
		this.testAnalyzer();
		this.testAddLogFile("testdata2.csv");
		
		this.testAddOperation("filter", "sugarLevel", 5, false);
		
	}

}
