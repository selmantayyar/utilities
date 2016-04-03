package com.utils.excel;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ExcelDataTest {
	
	@Test
	public void testExcelCalculation() throws Exception{
		
		ExcelDataCalculator.perform("INPUT_FILE_NAME", "OUTPUT_FILE_NAME");
	}

}
