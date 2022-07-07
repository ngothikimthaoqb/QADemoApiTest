package steps.users;

import models.users.GenerateTokenResponse;
import models.users.UserRequest;
import apis.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import steps.ScenarioContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class GenerateToken {
    private ScenarioContext scenarioContext;
    private UserRequest userRequest;
    private Response tokenResponse;
    private GenerateTokenResponse generateTokenResponse;
    private User user = new User();

    public GenerateToken(ScenarioContext scenarioContext, UserRequest userRequest,
                         GenerateTokenResponse generateTokenResponse) {
        this.userRequest = userRequest;
        this.scenarioContext = scenarioContext;
        this.generateTokenResponse = generateTokenResponse;
    }
    @Given("^I create token with username as (.*) and password as (.*)$")
    @When("^I generate token with username as (.*) and password as (.*)$")
    public void generateToke(String username, String password) throws IOException, URISyntaxException {
        userRequest = user.setUserRequest(username, password);
        tokenResponse = user.generateToken(userRequest);
        generateTokenResponse = tokenResponse.as(GenerateTokenResponse.class);
        scenarioContext.setContext("GenerateTokenResponse", generateTokenResponse);
    }

    @Then("^I verify generate token successfully$")
    public void verifyGenerateTokenSuccessfully(){
        user.verifyGenerateTokenSuccessfully(tokenResponse);
    }
}