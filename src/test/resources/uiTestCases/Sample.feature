Feature: Login Page Validation

  @Smoke
  Scenario: Validate User is on facebook login page.
    Given User is on login page
    When User enters "Invalid User" as UserName
    And User enters "Invalid Password" as Password
    And User clicks on LoginButton
    Then User navigates to "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110"
