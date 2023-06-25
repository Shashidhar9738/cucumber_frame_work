Feature: Validate all the end points of simple books by using athenticating with user credentials

  Scenario: verify login api to fetch accesstoken
    #given is a pre condition
    Given login to api
    # WHen is the action performed
    When Execute login "/api-clients/" which provides accesstoken
    # Then is a ppost condition kind of verifying the result
    Then verify the status code 201
    # And is an extra condition
    And verify the access token is fetched

  Scenario: Verifying the order
    Given login successfull with accessToken
    When order a book "/orders" and fetch the order id
    Then Verify the Status code is 201
    And verify the order id from the response
