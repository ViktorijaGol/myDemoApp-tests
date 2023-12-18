Feature: Products sorting functionality
  Background: User is on the "Products" page
    Given User is on "Catalog" page

  Scenario Outline: User can sort products by multiple criteria
    Given User clicks "sort button" button
    When User clicks on "<sorting option>" button
    Then First product title is "<product title>"
    Examples:
      | sorting option       | product title                |
      | Name - Ascending     | Sauce Labs Backpack          |
      | Name - Descending    | Test.allTheThings() T-Shirt  |
      | Price - Ascending    | Sauce Labs Onesie            |
      | Price - Descending   | Sauce Labs Fleece Jacket     |