Feature: Registration in moneygaming.com 

Scenario Outline: Validate the Password field during registration 

	Given I am in the Moneygaming website signup page 
	When I enter the password as "<Password>" 
	Then I should see the error message "<Error>" under the password field 
	
	
	Examples: 
		|Password | Error  |
		|Test     | The minimum length is 6 characters |
		|Tester   | Appropriate Error Message          |
		|Test10   | Appropriate Error Message          |
		|Test@    | Appropriate Error Message          |
		|T@123    | The minimum length is 6 characters |
		
		
		
Scenario Outline: Validate the valid Password during registration 

	Given I am in the Moneygaming website signup page 
	When I enter the password as "<Password>" 
	Then the password should be accepted and the user should successfully registered with the password
	
	
	Examples: 
		|Password |	
		|Test@12  |
		|&12Tester|
		
		
		
	