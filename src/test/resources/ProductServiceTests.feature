@functional
Feature: Validate Product

  Scenario: Create Product
    When I create new product 'Test watch' with price '300'$ and qty '100'
    Then Next products were created
      | Test watch |

  Scenario: Delete product by Name
    When I create new product 'Test delete Product' with price '1'$ and qty '1'
    Then Next products were created
      | Test delete Product |
    When I delete created product from product list
    Then The 'Test delete Product' was deleted


