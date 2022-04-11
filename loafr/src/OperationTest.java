import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Sean
 *
 */
class OperationTest extends Operation {

	public OperationTest(String opColumn) {
		super(opColumn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test method for {@link Operation#Operation(java.lang.String)}.
	 */
	@Test
	void testOperation() {
		System.out.println("testing operation creation");
		String thisClass = ""+this.getClass();
		//System.out.println(aClass);
		assert thisClass.equals("class Operation"): "failed to correctly construct Log Entry";
		System.out.println("test passed");
	}

	/**
	 * Test method for {@link Operation#getOpColumn()}.
	 */
	@Test
	void testGetOpColumn() {
		System.out.println("testing operation creation");
		assert this.getOpColumn().equals("timestamp"):"operation column header incorrect";
		System.out.println("test passed");
	}
	
	
	public void runTests() {
		
		this.testOperation();
		this.testGetOpColumn();
	}

}
