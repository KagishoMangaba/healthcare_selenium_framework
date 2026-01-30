Feature: Login flow

  Background: The user is on the Login Page

  Scenario Outline: Successfully login with Accepted credentials
    Given the user has landed on the landing page
    Given the user logs in with username "<username>" and password "<password>"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |