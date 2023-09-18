Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission
    Given I access the webdriver university contact us page
    When I fill in the following information:
      | Field    | Value                  |
      | Name     | John                   |
      | LastName | Doe                    |
      | Email    | johndoe@example.com    |
      | Comments | Inquiry about services |
    And I click on the Submit button
    Then I should see a confirmation message
