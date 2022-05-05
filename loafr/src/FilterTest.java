import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Sean
 *
 */
class FilterTest extends Filter{

	public FilterTest(String opColumn, int filterValue, boolean filterIncludes) {
		super(opColumn, filterValue, filterIncludes);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test method for {@link Filter#Filter(java.lang.String, int, boolean)}.
	 */
	@Test
	void testFilter() {
		System.out.println("testing Filter creation");
		String thisClass = ""+this.getClass();
		//System.out.println(aClass);
		assert thisClass.equals("class Filter"): "failed to correctly construct Log Entry";
		System.out.println("test passed");
	}

	/**
	 * Test method for {@link Filter#getFilterValue()}.
	 */
	@Test
	void testGetFilterValue() {
		System.out.println("testing get Filter value function");
		assert this.getFilterValue()==11 : "Filter value was not set correctly";
		System.out.println("test passed");
	}

	/**
	 * Test method for {@link Filter#getFilterIncludes()}.
	 */
	@Test
	void testGetFilterIncludes() {
		System.out.println("testing get Filter includes function");
		assert this.getFilterIncludes()==false : "Filter includes value was not set correctly";
		System.out.println("test passed");
	}

	/**
	 * Test method for {@link Filter#getBySugarLevel()}.
	 */
	@Test
	void testGetBySugarLevel() {
		System.out.println("testing get Filter by sugar value function");
		assert this.getBySugarLevel()==false : "Filter by sugar value was not set correctly";
		System.out.println("test passed");
	}
	
	
	public void runTests() {
		this.testFilter();
		this.testGetFilterValue();
		this.getFilterIncludes();
		this.getBySugarLevel();
		
	}

}
