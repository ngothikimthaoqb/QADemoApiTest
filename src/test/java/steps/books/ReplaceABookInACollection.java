package steps.books;

import models.books.AddABookResponse;
import models.books.GetAllBooksResponse;
import models.books.ReplaceABookRequest;
import models.users.GenerateTokenResponse;
import models.users.CreateUserResponse;
import apis.Book;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import steps.ScenarioContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class ReplaceABookInACollection {
    private ScenarioContext scenarioContext;
    private ReplaceABookRequest replaceABookRequest;
    private Response replaceBookResponse;
    private CreateUserResponse userInfor;
    private GenerateTokenResponse tokenInfor;
    private Book book = new Book();

    public ReplaceABookInACollection(ScenarioContext scenarioContext, ReplaceABookRequest replaceABookRequest){
        this.scenarioContext = scenarioContext;
        this.replaceABookRequest = replaceABookRequest;

    }
    @When("^I replace a book from a collection$")
    public void replaceABookFromACollection() throws IOException, URISyntaxException {
        userInfor = (CreateUserResponse) scenarioContext.getContext("UserResponse");
        tokenInfor = (GenerateTokenResponse) scenarioContext.getContext("GenerateTokenResponse");
        AddABookResponse bookResponse = (AddABookResponse) scenarioContext.getContext("AddABookResponse");
        GetAllBooksResponse listBookInfor = (GetAllBooksResponse)scenarioContext.getContext("GetAllBooksResponse");
        String replacedBook = listBookInfor.getBooks().get(listBookInfor.getBooks().size() - 1).getIsbn();
        String existedBook = bookResponse.getBooks().get(0).getIsbn();
        replaceABookRequest = book.setReplaceABookRequest(replacedBook, userInfor.getUserID());
        replaceBookResponse = book.replaceABookInACollection(replaceABookRequest, tokenInfor.getToken(), existedBook);
    }

    @Then("^I verify replace a book from a collection successfully$")
    public void verifyReplaceABookFromACollectionSuccessfully() throws IOException, URISyntaxException {
        book.verifyReplaceABookFromACollectionSuccessfully(replaceBookResponse, userInfor.getUserID(), tokenInfor.getToken());
    }
}