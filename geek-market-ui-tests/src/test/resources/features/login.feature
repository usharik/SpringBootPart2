Feature: Login

  Scenario Outline: Successful Login to the page and logout after
    Given I open firefox browser
    When I navigate to login.html page
    And I provide username as "<username>" and password as "<password>"
    And I click on login button
    Then name should be "<name>"
    When click logout button
    Then user logged out

    Examples:
      | username | password | name |
      | admin | admin | admin |



