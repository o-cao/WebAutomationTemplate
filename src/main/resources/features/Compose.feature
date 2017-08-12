Feature: Compose

  As a Gmail user
  I would like to compose an email
  So that I can send an email message

  Scenario: User can compose an email
    Given I login and on dashboard page
    When I compose a new email
    Then I can see successful message