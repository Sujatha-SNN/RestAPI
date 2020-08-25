Feature: Create change request using Rest Assured

Background:
Given Load URL 
And Authentication with valid credentials


@CreateCR
Scenario Outline: Create change request using multiple data files
And Add body using <datafile> file
When Call Post method 
Then Verify the status code is <statuscode>


Examples: 
|datafile|statuscode|
|CRA1.json|201|
|CRA2.json|201|

