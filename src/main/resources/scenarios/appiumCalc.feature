@appium
Feature: Appium Example Feature
  #Sample Test Scenario Description
    
@applitools 
Scenario: Applitest Demo 
	
	Given I start application by name "Calculator" 
	Then I check window "Calc" 
	And add "6" to "7" 
	Then I check window "Calc after adding" 