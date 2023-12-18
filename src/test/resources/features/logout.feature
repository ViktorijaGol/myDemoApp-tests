
Feature: Log out functionality
  Background: User is logged in and wants to log out
    Given User is logged in
    And User is on "Log Out" page

  Scenario: User can successfully log out
    Given User sees message "Are you sure you sure you want to logout?"
    When User clicks on "LOG OUT" button
    Then User sees message "You are successfully logged out."
    When User clicks on "OK" button
    Then User is redirected to "Login" page

  Scenario: User changes his mind in the process of logout and stays logged in
    Given User sees message "Are you sure you sure you want to logout?"
    When User clicks on "CANCEL" button
    Then User is still logged in