package steps.books;

import models.books.AddABookRequest;
import models.books.AddABookResponse;
import models.books.GetAllBooksResponse;
import models.users.GenerateTokenResponse;
import models.users.CreateUserResponse;
import apis.Book;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import steps.ScenarioContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class AddABookToCollection {
    private ScenarioContext scenarioContext;
    private AddABookRequest addABookRequest;
    private Response addABookResponse;

    public AddABookToCollection(ScenarioContext scenarioContext,AddABookRequest addABookRequest){
        this.scenarioContext = scenarioContext;
        this.addABookRequest = addABookRequest;
    }
    @Given("^I add a book to a collection$")
    public void addABookToCollection() throws IOException, URISyntaxException {
        System.out.println(System.getProperty("environment") + "environment");
        Book book = new Book();
        CreateUserResponse userInfor = (CreateUserResponse) scenarioContext.getContext("UserResponse");
        GenerateTokenResponse tokenInfor = (GenerateTokenResponse) scenarioContext.getContext("GenerateTokenResponse");
        GetAllBooksResponse listBookInfor = (GetAllBooksResponse) scenarioContext.getContext("GetAllBooksResponse");
        //Set request body
        String isbn = listBookInfor.getBooks().get(0).getIsbn();
        addABookRequest = book.setAddABookRequest(isbn, userInfor.getUserID());
        addABookResponse = book.addABookToACollection(addABookRequest, tokenInfor.getToken());
        AddABookResponse bookInfor =  addABookResponse.as(AddABookResponse.class);
        scenarioContext.setContext("AddABookResponse", bookInfor);
    }
}