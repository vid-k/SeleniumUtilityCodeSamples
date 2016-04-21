package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.SearchPage;

public class SearchPageTest {
	
	@Test
	@Parameters({"searchString", "listCounter"})
	public void parameterTest(String searchString, int listCounter) 
	{		
		SearchPage sp = new SearchPage();
		sp.SearchFunction(searchString, listCounter);
	}
	
}

