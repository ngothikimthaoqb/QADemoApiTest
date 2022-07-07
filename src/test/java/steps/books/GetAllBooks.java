package steps.books;

import models.books.GetAllBooksResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import steps.ScenarioContext;
import apis.Book;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetAllBooks {
    private ScenarioContext scenarioContext;
    private Response listBooksResponse;
    private GetAllBooksResponse getAllBooksResponse;

    public GetAllBooks(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    @Given("^I get list of books$")
    @When("^I get all books$")
    public void getAllBooks() throws IOException, URISyntaxException {
        Book book = new Book();
        listBooksResponse = book.getAllBooks();
        getAllBooksResponse = listBooksResponse.as(GetAllBooksResponse.class);
        scenarioContext.setContext("GetAllBooksResponse", getAllBooksResponse);
    }
}
