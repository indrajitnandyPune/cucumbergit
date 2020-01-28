Feature: Login Functionality 

@data-driven
Scenario: Login with valid credentials 
	Given when i am on home page 
	When i enter uname and pwd 
	Then i am able to login
	
	Scenario: Lary search
	When Larry searches below products in the search box:
	|Carpet |
	|Headphone|
	|Cylotains|
	
	Then product should be added in the cart if available 
	
	@user-specific
	Scenario Outline: Login with valid credentials 
	Given when i am on home page 
	When user enters "<username>"and"<password>" 
	Then i am able to login
	
	Examples:
	|username|password|
	|lalitha|Password123|
	|ABC|XYZ|