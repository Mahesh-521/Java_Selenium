Feature: Login Functionality

Scenario: Verify Login
Given Launch the browser
And Navigate to the URL
Then Enter the username
And Enter the Password
And Click on Login Button
Then Login should be successful
Then Close the browser

Scenario: Verify Login
Given Launch the browser
And Navigate to the URL
Then Enter the invalid username
And Enter the Password
And Click on Login Button
Then Login should be unsuccessful
Then Close the browser