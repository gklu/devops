@Testfooter
Feature: Footer Verification 


Background: User in homepage 
Given user in the homepage
# User should be able to see constant footer across all the site.

Scenario: Verify the footer is displayed on the homepage
Then the footer should be displayed 

Scenario: Verify the footer is displayed on the Dashboard page
When user lands to the Dashboaord 
Then the footer should be displayed 

Scenario: Verify the footer is displayed on the All Programs page
When user lands to the All Programs
Then the footer should be displayed 

Scenario: Verify the footer is displayed on the All Studies page
When user lands to the All Studies
Then the footer should be displayed 
@allCase
Scenario: Verify the footer is displayed on the All Cases page
When user lands to the All Studies
Then the footer should be displayed 
@about
Scenario: Verify the footer is displayed on the About page
When user lands to  the About page
Then the footer should be displayed 
