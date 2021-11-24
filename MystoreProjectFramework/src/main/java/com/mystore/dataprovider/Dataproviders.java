/**
 * 
 */
package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

/**
 * @author admin
 *
 */
public class Dataproviders {
	
	NewExcelLibrary obj = new NewExcelLibrary("F:\\HYR Selenium Tutorials\\MystoreProjectFramework\\TestData\\TestData.xlsx");
	
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		
		int rows=obj.getRowCount("Credentials");
		int column = obj.getColumnCount("Credentials");
		int actRows=rows-1;
		
		Object[][] data = new Object[actRows][column];
		
		for(int i=0; i<actRows; i++) {
			for(int j=0; j<column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}

	



}