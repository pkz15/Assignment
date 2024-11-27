package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DynamicTablePage {

    WebDriver driver;

    public DynamicTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements using PageFactory
    }

    private By addButton = By.xpath("//button[contains(text(),'Add Row')]");
    private By RemoveButton = By.xpath("//button[contains(text(),'Remove Row')]");


    private By tableLocator = By.xpath("//table[@id='myTable']");

    private By rowsLocator = By.xpath("//table[@id='myTable']/tbody/tr");

    private By headerCellsLocator = By.xpath("//table[@id='myTable']/tbody/tr/td");

    public void clickAddRowButton() {
        WebElement button = driver.findElement(addButton);
        button.click();
    }
    public void clickDeleteRowButton() {
        WebElement button = driver.findElement(RemoveButton);
        button.click();
    }

    public List<WebElement> getTableRows() {
        WebElement table = driver.findElement(tableLocator);
        return table.findElements(rowsLocator);
    }

    public List<WebElement> getHeaderCells() {
        WebElement table = driver.findElement(tableLocator);
        return table.findElements(headerCellsLocator);
    }
}
