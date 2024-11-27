package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.LoginPage;
import utils.ConfigProperties;
import utils.WebDriverManager;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
  

    @Given("User opens the browser and navigates to login page")
    public void openLoginPage() {
        driver = WebDriverManager.getDriver(ConfigProperties.property.getProperty("browser"));
        driver.get(ConfigProperties.property.getProperty("url"));
        loginPage = new LoginPage(driver);
//        configFileReader= new ConfigFileReader();
    }

    @When("User enters valid username and password")
    public void enterCredentials() {
        loginPage.enterUsername(ConfigProperties.property.getProperty("username"));
        loginPage.enterPassword(ConfigProperties.property.getProperty("password"));
        loginPage.clickLogin();
    }

    @Then("User should be successfully logged in")
    public void verifyLogin() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Thread.sleep(3);
    }

    @When("User enters invalid username {string} or password {string}")
    public void enterInvalidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("User should see error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage);
    }
    
}

