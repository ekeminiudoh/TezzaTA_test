Feature: User Registration
I want to check that the user can register on the website

  Scenario: User Registration
  Given the user is on the register page
  When user enters all the required details
  And clicks submit
  Then The registration page displayed successfully
  
