Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Verify form of sign in for incorrect email input
    Given User opens '<homePage>' page
    And User moves cursor on icon of sign in
    And User checks that icon of my account is visible
    And User clicks on icon of my account
    And User enters '<email>' and '<password>'
    And User clicks button of sign in
    Then User check a '<massage>' about wrong email
    Examples:
      | homePage              | email | password | massage                                               |
      | https://www.asos.com/ |       | 33       | Oops! You need to type your email here                |
      | https://www.asos.com/ | 1     | 33       | Email fail! Please type in your correct email address |

  Scenario Outline: Check correct work of sort by price
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    And User clicks on menu of sort
    And User chooses sort by '<type of sort>'
    And User checks that '<type of sort>' is updated
    Then User checks that products are sorted by '<type of sort>'
    Examples:
      | homePage              | type of sort  | keyword |
      | https://www.asos.com/ | FromHighToLow | casio   |
      | https://www.asos.com/ | FromLowToHigh | casio   |

  Scenario Outline: Check that price with sale is lower then old price
    Given User opens '<homePage>' page
    And User chooses products for man
    And User moves cursor on icon of sale
    And User clicks on button off view all
    Then User checks that price with sale is correct
    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check search by keyword
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User checks that search is working
    Then User check that search is working correctly and all products contains '<keyword>'
    Examples:
      | homePage              | keyword |
      | https://www.asos.com/ | shirt   |

  Scenario Outline: Check filter products by brand
    Given User opens '<homePage>' page
    And User chooses products for man
    And User makes search by keyword '<keyword>'
    And User clicks on filter by brand
    And User chooses filter by Abercrombie
    And User checks that filter is active
    Then User checks that filter is correct and all products are '<brand>'
    Examples:
      | homePage              | brand       | keyword |
      | https://www.asos.com/ | Abercrombie | polo    |

  Scenario Outline: Verify to buy product without choosing options
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks add to bag button on product
    Then User checks '<massage>' about missing choose side visibility
    Examples:
      | homePage              | keyword   | massage                                                  |
      | https://www.asos.com/ | 106379999 | Please select from the available colour and size options |

  Scenario Outline: Verify add product to wish list
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks add product to wish list
    And User clicks on button of wish list page
    And User checks visibility of product in wish list
    Then User checks that the name of product in wish list is '<keyword>'
    Examples:
      | homePage              | keyword                             |
      | https://www.asos.com/ | Ted Baker long sleeve shirt in navy |

  Scenario Outline: Check function to swap country
    Given User opens '<homePage>' page
    And User clicks on button for choose country
    And User checks that preferences is open
    And User clicks country menu button
    And User choose '<country>'
    And User click on button of update
    Then User check a new country's flag
    Examples:
      | homePage              | country |
      | https://www.asos.com/ | Us      |

  Scenario Outline: Check opportunity to swap size of product after adding to bag
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    And User chooses '<size>' for product
    And User adds product to bag
    And User opens bag
    And User swap '<newSize>'
    Then User checks that product in '<newSize>'
    Examples:
      | homePage              | keyword   | size    | newSize |
      | https://www.asos.com/ | 113433589 | W30 L32 | W34 L34 |

  Scenario Outline: Check opportunity to delete product after adding to bag
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    And User chooses '<size>' for product
    And User adds product to bag
    And User opens bag
    And User clicks delete product from bag
    Then User checks that bag is empty
    Examples:
      | homePage              | keyword   | size    |
      | https://www.asos.com/ | 113433589 | W30 L32 |



