Feature: Registration in moneygaming.com 


Scenario: Validate the Error Message in the Date of Birth Field 

	Given I am in the Moneygaming website signup page 
	When I select the title from the title dropdown 
	And I enter the firstname and surname in the form 
	And I check the terms and conditions checkbox 
	And I click on Join Now buttton 
	Then I should see an error Message "This field is required" under the Date of birth field 
	
    