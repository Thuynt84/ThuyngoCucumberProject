Feature: Add to cart


  Scenario: Add one quantity from Store
    Given I'm on the Store Page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart


  Scenario Outline: Add one quantity from Store 2
    Given I'm on the Store Page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name     |
      | Blue Tshirt      |
      | Basic Blue Jeans |

