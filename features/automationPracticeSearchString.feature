Feature: Automation Practice Search

Scenario Outline: Searche Dresses

Given Launch Browser With URL "http://automationpractice.com/index.php"
When Enter Search String "<Search String>"
Then Summer Dresses search page should appear
Examples:
			|Search String|
			|Summer Dresses|
			|Casual Dresses|
			|T-Shirts|

Scenario: User Creation 
Given Click on Sign in
When Enter Email Id On create User
And Enter User details and click on Register user
Then User creation should be successful




