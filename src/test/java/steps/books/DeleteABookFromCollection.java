package steps.books;

import models.books.AddABookResponse;
import models.books.DeleteBookRequest;
import models.users.GenerateTokenResponse;
import models.users.CreateUserResponse;
import apis.Book;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import steps.ScenarioContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class DeleteABookFromCollection {

    private ScenarioContext scenarioContext;
    private DeleteBookRequest deleteBookRequest;
    private Response deleteBookResponse;
    private Book book = new Book();

    public DeleteABookFromCollection(ScenarioContext scenarioContext,DeleteBookRequest deleteBookRequest){
        this.scenarioContext = scenarioContext;
        this.deleteBookRequest = deleteBookRequest;
    }
    @When("^I delete a book from a collection$")
    public void deleteABookFromACollection() throws IOException, URISyntaxException {
        CreateUserResponse userInfor = (CreateUserResponse) scenarioContext.getContext("UserResponse");
        GenerateTokenResponse tokenInfor = (GenerateTokenResponse) scenarioContext.getContext("GenerateTokenResponse");
        AddABookResponse bookResponse = (AddABookResponse) scenarioContext.getContext("AddABookResponse");
        deleteBookRequest = book.setDeleteBookRequest(userInfor.getUserID(), bookResponse.getBooks().get(0).getIsbn());
        book.deleteABookFromCollection(deleteBookRequest, tokenInfor.getToken());
    }

    @Then("^I verify delete a book from a collection successfully$")
    public void verifyDeleteABookFromACollectionSuccessfully() {
        System.out.println("abc");
    }
}

