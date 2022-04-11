import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FilterTest extends Filter  {


	@Test
	void testFilterValue() {
		System.out.println("testing Filter value");
		
		assert this.opColumn.equals("sugarlevel");
	
		System.out.println("test passed");
	}

	@Test
	void testMultipleFilters() {
		System.out.println("testing Multiple Filters");
		
		assert this.bySugarLevel.equals(True);

		System.out.println("test passed");
	}

	@Test
	void testGetFilterIncludes() {
		System.out.println("testing testGetFilterIncludes");
		assert this.getFilterIncludes()==False:"GetFilterIncludes function returned incorrect result";
		System.out.println("test passed");
	}

	@Test
	void testGetBySugarLevel() {
		System.out.println("testing GetBySugarLevel()");
		assert this.getBySugarLevel()== 0:"GetBySugarLevel()function returned incorrect result";
		System.out.println("test passed");
	}

	
	public void runTests() {
		this.testFilterValue();
		this.testMultipleFilters();
		this.testGetFilterIncludes();
		this.testGetBySugarLevel();
		
	}

}