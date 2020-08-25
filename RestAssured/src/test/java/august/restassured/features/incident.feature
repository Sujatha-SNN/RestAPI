Feature: Create new incident using API

Background:
Given Setup the base URI for incident api
And Authentication with valid credentials

@Incident
Scenario Outline: Create new incident by passing data file
And Pass the data file as <filename> file
When Place the post request
Then Verify the status code as 201

Examples:
|filename|
|IncData1.json|
|IncData2.json|




Scenario: Get incident from service now


And Get  incident from service now
