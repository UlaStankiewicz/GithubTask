Feature: Issue management

  Background:
    Given User is on the login page
    When User fills the form with "TestAccount583" and "P234@m!B$tZ55w4" and clicks 'Sign In' button
    And User goes to target repository
    And User goes to issues section

  Scenario Outline: Create and update issue
    When User creates a new issue and fills input fields with data "<issueTitle>" , "<issueBody>" and submits new issue
    Then New issue is displayed and title is equal to "<issueTitle>"
    When User clicks edit button, changes title with "<postscriptToTitle>" and submits the change
    Then New issue is displayed and title is equal to "<issueTitleAfterUpdate>"

    Examples:
    |issueTitle|issueBody|postscriptToTitle|issueTitleAfterUpdate|
    |TestTitle |TestBody |AfterUpdate      |AfterUpdateTestTitle |

    Scenario: Assign issue to user
      When User goes to pinned issue
      And User assigns himself to the issue
      And User unassigns himself form issue
      Then Button assign yourself is displayed again

#Space for further issue-related scenarios



