Feature: each post is a part of hub

  Scenario: Get all posts by hub
    Given I am on hub page
    When I search hub "Тестирование IT-систем"
    And choose found hub
    And each post has hub label "IT systems testing"