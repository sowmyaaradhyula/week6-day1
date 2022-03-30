Feature: Various scenarios in LeafTaps page
Background:
Given A Chrome Browser is launched
And Load the Leaftaps URL 'http://leaftaps.com/opentaps/control/main'
And Maximize the browser
And Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When The Login button is clicked
Then Welcome page should be displayed
When Clicked on CRM/SFA link 
And Clicked on Leads


Scenario Outline: TC001 Create a Lead in LeafTaps page
Given Clicked on Create Lead
And Enter companyname as <companyname>
And Enter firstname as <firstname>
And Enter lastname as <lastname>
And Click on Create Lead Button
Then View Lead page should be displayed


Examples:

|companyname||firstname||lastname|
|'ibm'||'gopi'||'sundar'|


Scenario Outline: TC002 Delete a Lead in LeafTaps page
Given Clicked on Find Leads
And Clicked on Phone
And Enter Phone Number as <phonenumber>
And Clicked on Find Leads Button
And Click on first result lead
And Click on Delete
Then My Lead page should be displayed

Examples:

|phonenumber|
|'99'|

Scenario Outline: TC003 Edit a Lead in LeafTaps page
Given Clicked on Find Leads
And Clicked on Phone
And Enter Phone Number as <phonenumber>
And Clicked on Find Leads Button
And Click on first result lead
And Click on Edit
And Update companyname as <updatecompanyname>
And Click on Update
Then View Lead page should be displayed after editing the lead

Examples:

|phonenumber||updatecompanyname|
|'99'||'css'|

Scenario Outline: TC004 Duplicate a Lead in LeafTaps page
Given Clicked on Find Leads
And Clicked on Phone
And Enter Phone Number as <phonenumber>
And Clicked on Find Leads Button
And Click on first result lead
And Clicked on Duplicate Lead
And Click on Create Lead Button
Then View Lead page should be displayed after Duplicating the lead

Examples:

|phonenumber|
|'99'|

Scenario Outline: TC005 Merge Leads in LeafTaps page
Given Clicked on Merge Leads 
And Clicked on From Lead image
And Clicked first resulting lead in From Lead Image <fromfirstname>
And Clicked on To Lead image
And Clicked first resulting lead in To Lead Image <tofirstname>
When Click on Merge
Then View Lead page should be displayed after merging the lead

Examples:

|fromfirstname||tofirstname|
|'gopi'||'sundar'|

