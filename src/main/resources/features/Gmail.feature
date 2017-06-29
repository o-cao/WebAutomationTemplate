Feature: Gmail

  As a Gmail user
  I would like to login in my Gmail account
  So that I can check my emails in Gmail

  Scenario: User can check mails after login
    Given I open Gmail login page
    When I login in with my Google account
    Then I can see inbox