@functional
Feature: Validate Cart

  Scenario: Verify first cart products
    Then the carts endpoint exists and response status code should be 200
    When I get first cart info
    Then Next products are present on cart
      | polo        |
      | jean        |
      | coat        |

  Scenario: Create new Cart and add some product to this cart
    When I create new cart
    Then New cart is exists
    When I add 'Top' product with '1' qty and '10'$ price to this cart
    Then Next products are present on cart
      | Top        |


  Scenario: Delete first Cart
    When I get first cart info
    When I delete first cart
    Then First cart was deleted


  Scenario: Delete first Cart
    When I get first cart info
    When I delete first cart
    Then First cart was deleted