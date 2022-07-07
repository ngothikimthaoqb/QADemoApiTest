package steps.users;

import models.users.UserRequest;
import models.users.CreateUserResponse;
import apis.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import steps.ScenarioContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreateUser {
    private ScenarioContext scenarioContext;
    private Response createUserResponse;
    private UserRequest userRequest;
    private CreateUserResponse userResponse;
    private User user = new User();

    public CreateUser(ScenarioContext context, CreateUserResponse userResponse, UserRequest userRequest) {
        this.scenarioContext = context;
        this.userResponse = userResponse;
        this.userRequest = userRequest;
    }
    @Given("^I create user with username as (.*) and password as (.*)$")
    @When("^I create new user with username as (.*) and password as (.*)$")
    public void createUser(String username, String password) throws IOException, URISyntaxException {
        userRequest = user.setUserRequest(username,password);
        createUserResponse = user.createUser(userRequest);
        userResponse = createUserResponse.as(CreateUserResponse.class);
        scenarioContext.setContext("UserRequest", userRequest);
        scenarioContext.setContext("UserResponse", userResponse);
    }

    @Then("^I verify create new user successfully$")
    public void verifyCreateNewUserSuccessfully(){
        user.verifyCreateUserSucessfully(createUserResponse, userRequest);
    }


}
