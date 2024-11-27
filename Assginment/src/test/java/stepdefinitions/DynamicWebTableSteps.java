package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.DynamicTablePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverManager;

public class DynamicWebTableSteps {
	WebDriver driver;
	DynamicTablePage dynamicTablePage;

	@Given("I open the Dynamic page")
	public void iOpenThePage() {
		driver = WebDriverManager.getDriver("Chrome");
		driver.get(System.getProperty("user.dir") + "/"+"src/test/resources/Drivers/Table.html");
//        Dropdown = new DropdownPage(driver);
		dynamicTablePage = new DynamicTablePage(driver); // Initialize the Page Object
	}

	@When("I click the {string} button to add a new row for {int} time")
	public void iClickTheButtonToAddANewRow(String buttonName, int times) {
		for (int i = 1; i <= times; i++) {
			dynamicTablePage.clickAddRowButton();
		}
	}
	
	@Then("the table should have {int} rows")
	public void theTableShouldHaveRows(int expectedRowCount) {
		List<WebElement> rows = dynamicTablePage.getTableRows(); 
		assertEquals("Table row count doesn't match the expected", expectedRowCount, rows.size());
	}

	@Then("the table should have the following field names:")
	public void theTableShouldHaveTheFollowingFieldNames(List<List<String>> expectedFieldNames) {
		List<WebElement> cells = dynamicTablePage.getHeaderCells(); 
		if(cells.size()<0)
		{
			for (int i = 0; i < expectedFieldNames.get(0).size(); i++) {
				assertEquals("Field name does not match", expectedFieldNames.get(0).get(i), cells.get(i).getText());
			}
		}
		else
		{
			System.out.println("No rows left");
		}
		
	}
	  @When("I click the {string} button to delete a new row for {int} time")
	    public void iClickTheRemoveRowButton(String button, int times) {
	    
		  for (int i = 0; i < times; i++) {
		        // Check if there are rows left to delete
		        List<WebElement> rows = dynamicTablePage.getTableRows();
		        if (rows.size() > 0) {
		        	dynamicTablePage.clickDeleteRowButton();
		        } else {
		            throw new RuntimeException("No rows left to delete!");
		        }
		    }
	    }

	
}
