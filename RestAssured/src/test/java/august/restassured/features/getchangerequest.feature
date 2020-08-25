Feature: Get change request using Rest Assured

Background:
Given Load URL 
And Authentication with valid credentials


@GetCR
Scenario: Create change request using multiple data files
When Call Get method 
Then Check the status code is 200



