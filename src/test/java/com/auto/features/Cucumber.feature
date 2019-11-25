@cucumber
Feature: Cucumber
	 As
	 I want to 
	 So I can
	 
Scenario Outline: Add two items to cart
	Given I am on the YourLogo homepage
	When I Quick view the first item "<title1>"
	And I change the size of the item "<size1>"
	And I add to cart
	And I continue shopping
	And I Quick view the second item "<title2>"
	And I follow the same instructions, with the size "<size2>"
	Then the cart tab shows the correct items - "<title1>" - "<title2>"
	And the correct prices - "<cost1>" - "<cost2>"
	And the sum of the two items - "<cost1>" - "<cost2>"
	And the shipping fee - "<shipping>"
	And the total cost including the shipping fee - "<cost1>" - "<cost2>" - "<shipping>" 
	
	Examples:
	| title1 | title2 | cost1 | cost2 | size1 | size2 | shipping |
	| Faded Short Sleeve T-shirts | Blouse | $16.51 | $27 | 3 | 2 | $2 |

#Scenario Outline: Check the two items in the cart summary
#	Given I am on the YourLogo homepage
#	When I add the two items to cart - "<title1>" - "<size1>" - "<title2>" - "<size2>"
#	And I click on the cart tab
#	Then the cart summary page shows the correct items - "<title1>" - "<title2>"
#	And the page shows the correct prices - "<cost1>" - "<cost2>"
#	And the page shows the sum of the two items - "<cost1>" - "<cost2>"
#	And the page shows the shipping fee - "<shipping>"
#	And the page shows the total cost including the shipping fee - "<cost1>" - "<cost2>" - "<shipping>" 
#	
#	Examples:
#	| title1 | title2 | cost1 | cost2 | size1 | size2 | shipping |
#	| Faded Short Sleeve T-shirts | Blouse | $16.51 | $27 | 3 | 2 | $2 |
#	
#Scenario Outline: Purchase two items
#	Given I am on the YourLogo homepage
#	When I add the two items to cart
#	And I click on the cart tab
#	And I click on proceed to checkout under summary
#	And I sign in using my email address "<email>" and password "<password>"
#	And I click on proceed to checkout under address
#	And I agree to the terms of service
#	And I click on proceed to checkout under shipping
#	And I choose to pay by bank wire
#	And I confirm my order
#	Then my order is placed and displays the corfirmation message "<confirmation>"
#	And the total cost is shown  - "<cost1>" - "<cost2>" - "<shipping>"
#	
#	Examples:
#	| email | password | corfirmation | cost1 | cost2 | shipping |
#	| vinu89628@test.com | Scotg0v@201g | Your order on My Store is complete. | $16.51 | $27 | $2 |
#	
#Scenario Outline: Review previous orders
#	Given I am on the YourLogo homepage
#	When I click on the sign in tab
#	And I sign in using my email address "<email>" and password "<password>"
#	And I click on order history and details
#	Then I see my order stating the price total - "<cost1>" - "<cost2>" - "<shipping>"
#	
#	Examples:
#	| email | password | cost1 | cost2 | shipping |
#	| vinu89628@test.com | Scotg0v@201g | $16.51 | $27 | $2 |
#	
#Scenario Outline: Add a message to the previous orders
#	Given I am on the YourLogo homepage
#	When I sign in and view the order history and details - "<email>" - "<password>"
#	And I click on the details link under my order
#	And I add the following message "<message>"
#	Then I see my comment "<message>" under the message section
#	
#	Examples:
#	| email | password | message | cost1 | cost2 | shipping |
#	| vinu89628@test.com | Scotg0v@201g | test automation | $16.51 | $27 | $2 |