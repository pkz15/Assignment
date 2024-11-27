Feature: Cascading dropdown functionality

  Scenario: Verify cascading dropdowns behavior
    Given I am on the webpage with cascading dropdowns
    When I select a "Front-end" subject from the dropdown and Validating topics
    Then I select a Topic from the "HTML" dropdown
		Then I select a Chapter from the "Links" dropdown
    #When I select a topic from the "Topics" dropdown
    #Then the "Chapters" dropdown should show relevant chapters for that topic
    When I select a "Back-end" subject from the dropdown and Validating topics
    Then I select a Topic from the "PHP" dropdown
		Then I select a Chapter from the "Arrays" dropdown
		Then I select a "Back-end" subject from the dropdown and "HTML" topics
		
		