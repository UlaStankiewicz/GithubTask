Feature: Login process

  Scenario Outline: Successful login with the correct credentials

    Given User is on the login page
    When  User fills the form with "<login>" and "<password>" and clicks 'Sign In' button
    Then  User is able to see his home page

    Examples:
    |login|password|
    |TestAccount583|P234@m!B$tZ55w4|

#space for further login-related scenarios