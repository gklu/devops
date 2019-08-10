@db
Feature: Integration test for All Studies - Stats bar values 


Background: User in homepage 
Given user in the homepage
When the user clicks on the "All Studies" page 
Then the user is redirected to the "Study Details" page of the study in question


Scenario: verify stats bar 
Then the Statistics Bar is displayed at the top of the page

Scenario: Stats Bar displays total number of Studies
And the total number of studies associated with the study displayed in the Stats Bar should match the database record

Scenario:  Stats Bar displays total number of Cases 
And the total number of cases associated with the study displayed in the Stats Bar should match the database record

Scenario: Stats Bar displays total number of Samples
And the total number of samples associated with the study displayed in the Stats Bar should match the database record

Scenario: Stats Bar displays total number of files 
And the total number of biospecimen aliquots associated with the study displayed in the Stats Bar should match the database record

Scenario: Stats Bar displays total number of Biospecimen Aliquots
And the total number of biospecimen aliquots associated with the study displayed in the Stats Bar should match the database record




