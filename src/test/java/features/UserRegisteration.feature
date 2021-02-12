Feature: User Registeration
   I want to check that the user can register in our e-commerce website.
   
   Scenario Outline: User Registeration
   Given the user in home page
   When I click on register link
   And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
   Then The registeration page displayed successfully
   
   Examples:
   
   | firstname | lastname | email | password |
   | automation | user | automationuser@gmail.com | 12355566 |
   | user | automation | automationuser2021@gmail.com | 695112222 |