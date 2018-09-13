Feature:  Game introduction
  I as a user want to be able to:
  Open the game
  Press the “PLAY” button
  See the game presentation screen

  Scenario: Start the game
    Given I navigate to the game page
    When I press the Play button
    And I see the game presentation screen
    And I press H to start the game
    Then I can start to play the game

