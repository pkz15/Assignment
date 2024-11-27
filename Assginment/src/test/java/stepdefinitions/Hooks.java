package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.ConfigProperties;
import utils.ExtendReport;
import utils.WebDriverManager;

public class Hooks {
	@Before
	public void beforeScenario() {
		ConfigProperties.initializePropertyFile();
		ExtendReport.clearOldReport();
		ExtendReport.init();
	}

	@After
	public void afterScenario(Scenario scenario) {
		ExtendReport.createTest(scenario);
		ExtendReport.logResult(scenario);
		ExtendReport.flushReport();
		WebDriverManager.closeDriver();
	}
}
