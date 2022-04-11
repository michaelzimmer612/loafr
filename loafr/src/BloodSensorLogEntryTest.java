import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Sean
 *
 */
class BloodSensorLogEntryTest extends BloodSensorLogEntry{

	

	public BloodSensorLogEntryTest(String logFileType, String timestamp, String eventType, String deviceID,
			String eventMessage, String sugarLevel) {
		super(logFileType, timestamp, eventType, deviceID, eventMessage, sugarLevel);
		// TODO Auto-generated constructor stub
	}
	
	
	void testBloodSensorLogEntry() {
		System.out.println("testing blood sensor log entry creation");
		String thisClass = ""+this.getClass();
		//System.out.println(aClass);
		assert thisClass.equals("class BloodSensorLogEntry"): "failed to correctly construct Log Entry";
		System.out.println("test passed");
		
	}

	/**
	 * Test method for {@link BloodSensorLogEntry#toString()}.
	 */
	@Test
	void testToString() {
		System.out.println("testing convert to string function");
		String thisClass = ""+this.toString().getClass();
		assert thisClass.equals("class String"): "failed to convert values to string";
		System.out.println("test passed");
	}
	
	


	/**
	 * Test method for {@link BloodSensorLogEntry#getSugarLevelFilter()}.
	 */
	@Test
	void testGetSugarLevelFilter() {
		System.out.println("testing get sugar level filter function");
		assert this.getSugarLevelFilter() == false: "incorrect value for sugar level filter";
		System.out.println("test passed");
	}
	
	/**
	 * Test method for {@link LogEntry#setTimestampFilter(boolean)}.
	 */
	@Test
	void testSetTimestampFilter() {
		System.out.println("testing set timestamp filter function");
		this.setTimestampFilter(true);
		assert this.getTimestampFilter()==true: "timestamp filter is incorrect";
		System.out.println("test passed");
	}

	
	
	
	
	
	public void runTests() {
		this.testBloodSensorLogEntry();
		this.testToString();
		this.testSetTimestampFilter();
		
	}

}
