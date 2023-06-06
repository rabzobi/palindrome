Feature: Palindrome Endpoint
  I want to check if a given word is a palindrome
  So that I can determine if it reads the same backward as forward

  Scenario: Valid palindrome value
    Given a word "madam"
    When I make a POST request to the palindrome endpoint
    Then the response should be "true" with status code 200

  Scenario: Invalid palindrome value
    Given a word "adam"
    When I make a POST request to the palindrome endpoint
    Then the response should be "false" with status code 200
