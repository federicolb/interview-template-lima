Feature: Blocks Chaining
  Verify that the blocks are being chained correctly.

  Scenario: Successive blocks should be well chained
    Given the initial block number 15
    When I check the next 5 blocks
    Then I should be able to follow the chain up to the initial block