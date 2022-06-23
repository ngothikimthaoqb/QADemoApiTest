package steps.users;

import models.users.CreateUserResponse;
import models.users.GenerateTokenResponse;
import apis.User;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import steps.ScenarioContext;

public class GetUserInformation {
    private ScenarioContext scenarioContext;
    private Response userInformationResponse;
    private CreateUserResponse userInfor;
    private User user = new User();

    public GetUserInformation(ScenarioContext context) {
        this.scenarioContext = context;
    }

    @When("^I get user information$")
    public void getUserInformation() {
        userInfor = (CreateUserResponse) scenarioContext.getContext("UserResponse");
        GenerateTokenResponse tokenInfor = (GenerateTokenResponse) scenarioContext.getContext("GenerateTokenResponse");
        userInformationResponse = user.getUserInformation(userInfor.getUserID(), tokenInfor.getToken());
    }

    @Then("^I verify get user information successfully$")
    public void verifyGetUserInformationSuccessfully(){
        user.verifyGetUserSuccessfully(userInformationResponse, userInfor);
    }
}
