package stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.CascadingDropdownPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigProperties;
import utils.WebDriverManager;

public class CascadingDropdownSteps {
	private WebDriver driver;
	private CascadingDropdownPage cascadingDropdownPage;
	
	
	@Given("I am on the webpage with cascading dropdowns")
	public void i_am_on_the_webpage_with_cascading_dropdowns() {
		driver = WebDriverManager.getDriver("Edge");
		driver.get(System.getProperty("user.dir") + "/"+"src/test/resources/Drivers/Cascade.html");
//        Dropdown = new DropdownPage(driver);
		cascadingDropdownPage = new CascadingDropdownPage(driver);
	}

	@When("I select a {string} subject from the dropdown and Validating topics")
	public void i_select_a_subject_from_the_dropdown(String subject) {
		cascadingDropdownPage.selectSubject(subject); // Select the subject from the dropdown
		boolean topicFound = false;
		if (subject.equalsIgnoreCase("front-end")) {
			List<WebElement> Ftopics = cascadingDropdownPage.getTopics();
			for (WebElement topic : Ftopics) {
				if (topic.getText().equals("HTML") || topic.getText().equals("CSS")
						|| topic.getText().equals("JavaScript")
						|| topic.getText().equals("Please select subject first")) {
					topicFound = true;
				}
			}
		} else if (subject.equalsIgnoreCase("Back-end")) {
			List<WebElement> Btopics = cascadingDropdownPage.getTopics();
			for (WebElement topic : Btopics) {
				if (topic.getText().equals("PHP") || topic.getText().equals("SQL")) {
					topicFound = true;
				}
			}
		}
		assertTrue("Relevant topics are not displayed", topicFound);
	}

	@Then("I select a Topic from the {string} dropdown")
	public void i_select_a_Topic_from_the_dropdown(String Topic) {
		List<WebElement> topics = cascadingDropdownPage.getTopics();
		for (WebElement topic : topics) {
			if (topic.getText().equalsIgnoreCase(Topic)) {
				cascadingDropdownPage.selectTopic(Topic);
			}
		}
	}

	@Then("I select a Chapter from the {string} dropdown")
	public void i_select_a_Chapter_from_the_dropdown(String Topic) {
		List<WebElement> topics = cascadingDropdownPage.getChapters();
		for (WebElement topic : topics) {
			if (topic.getText().equalsIgnoreCase(Topic)) {
				cascadingDropdownPage.selectChapter(Topic);
			}
		}
	}
	@Then("I select a {string} subject from the dropdown and {string} topics")
	public void i_select_a_subject_from_the_dropdown_Wrong_Topic(String subject, String Topic) {
		cascadingDropdownPage.selectSubject(subject); 
		boolean topicFound = true;
		if (subject.equalsIgnoreCase("front-end")) {
			List<WebElement> Ftopics = cascadingDropdownPage.getTopics();
			for (WebElement topic : Ftopics) {
				if (topic.getText().equalsIgnoreCase(Topic)) {
					topicFound = false;
				}
			}
		} else if (subject.equalsIgnoreCase("Back-end")) {
			List<WebElement> Btopics = cascadingDropdownPage.getTopics();
			for (WebElement topic : Btopics) {
				if (topic.getText().equalsIgnoreCase(Topic)) {
					topicFound = false;
				}
			}
		}
		assertTrue("Relevant topics are not displayed under "+subject,topicFound);
		System.out.println("Relevant topics are not displayed under "+subject);
	}
	
	
}
