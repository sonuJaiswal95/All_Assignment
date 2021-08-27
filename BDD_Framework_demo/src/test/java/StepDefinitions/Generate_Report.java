package StepDefinitions;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Generate_Report {
	
@Test
	
	@Given("set http path")
	
	public void set_http_path() {
		
}
		@When("parameterize the values")
		
		public void Parameterize_the_values() throws IOException {
			
			Response response;
			
			String path = "C:\\selenium\\Exceldata\\Book1.xlsx";
			
			FileInputStream file = new FileInputStream(path);
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			 XSSFSheet sheet =workbook.getSheetAt(0);
			 
			 
			 int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			 
			 
			 for(int i=1; i<=rowcount; i++) {
				 
				 String id = sheet.getRow(i).getCell(0).getStringCellValue();
				 response = RestAssured.get(" http://api.exchangeratesapi.io/v1/latest?access_key=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");
				 String responseBody = response.getBody().asString();
				 response.then().log().all();
				 System.out.println("ResponseBody is "+responseBody);
				 
				 //writing into Excel sheet
				 XSSFRow row = sheet.getRow(i);
				 XSSFCell cell = row.createCell(4);
				 cell.setCellValue(responseBody);
				 FileOutputStream file1 = new FileOutputStream(path);
				 workbook.write(file1);
				 
				 
				 }
		
	     workbook.close();	
		
			
			
		}
@Test

	@Then("Generate the Report")

	public void generate_the_report() {
	
	
	System.out.println("The Parameterize is validated");
}
		
		
	}


