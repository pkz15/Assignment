Feature: Login Functionality

@Positive
Scenario: Successful Login
  Given User opens the browser and navigates to login page
  When User enters valid username and password
  Then User should be successfully logged in

@Negative
Scenario: Failed Login
  Given User opens the browser and navigates to login page
  When User enters invalid username "wrongUser" or password "wrongPass"
  Then User should see error message "Epic sadface: Username and password do not match any user in this service"