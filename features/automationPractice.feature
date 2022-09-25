Feature: Automation Practice Search

Scenario: Searche Dresses

Given Launch Browser With URL "http://automationpractice.com/index.php"
When Enter Search String "Summer dresses"
Then Summer Dresses search page should appear

Given Click on Sign in
When Enter Email Id On create User
And Enter User details and click on Register user
Then User creation should be successful


