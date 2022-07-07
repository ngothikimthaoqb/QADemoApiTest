package apis;

import models.books.AddABookRequest;
import models.books.CollectionOfIsbn;
import models.books.DeleteBookRequest;
import models.books.ReplaceABookRequest;
import models.users.CreateUserResponse;
import apis.helpers.RestResource;
import constants.BookApiPaths;
import constants.Common;
import constants.UserApiPaths;
import io.restassured.response.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Book {

    public Response getAllBooks() throws IOException, URISyntaxException {
        return RestResource.get(BookApiPaths.GET_ALL_BOOKS, "");
    }

    public Response addABookToACollection(AddABookRequest addABookRequest, String token) throws IOException, URISyntaxException {
        return RestResource.post(BookApiPaths.ADD_A_BOOkS, addABookRequest, token);
    }

    public AddABookRequest setAddABookRequest(String isbn, String userId) {
        CollectionOfIsbn collectionOfIsbn = new CollectionOfIsbn();
        collectionOfIsbn.setIsbn(isbn);
        List<CollectionOfIsbn> collectionOfIsbnList = new ArrayList<>();
        collectionOfIsbnList.add(collectionOfIsbn);
        AddABookRequest addABookRequest = new AddABookRequest();
        addABookRequest.setUserId(userId);
        addABookRequest.setCollectionOfIsbns(collectionOfIsbnList);

        return addABookRequest;
    }

    public Response replaceABookInACollection(ReplaceABookRequest replaceABookRequest, String token, String existedBook) throws IOException, URISyntaxException {
        String path = BookApiPaths.REPLACE_A_BOOkS.concat(existedBook);

        return RestResource.put(path, replaceABookRequest, token);
    }

    public ReplaceABookRequest setReplaceABookRequest(String isbn, String userId) {
        ReplaceABookRequest replaceABookRequest = new ReplaceABookRequest();
        replaceABookRequest.setUserId(userId);
        replaceABookRequest.setIsbn(isbn);

        return replaceABookRequest;
    }

    public void verifyReplaceABookFromACollectionSuccessfully(Response replaceBookResponse, String userId, String token) throws IOException, URISyntaxException {
        Assert.assertEquals(replaceBookResponse.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(replaceBookResponse.contentType(), Common.CONTENT_TYPE);

        //Verify body
        String path = UserApiPaths.GET_USER_INFO.concat(userId);
        Response userInformationResponse = RestResource.get(path, token);
        CreateUserResponse expectedCreateUserResponse = userInformationResponse.as(CreateUserResponse.class);
        CreateUserResponse currentUserResonse = replaceBookResponse.as(CreateUserResponse.class);
        Assert.assertEquals(expectedCreateUserResponse.getUsername(), currentUserResonse.getUsername());
        Assert.assertEquals(expectedCreateUserResponse.getBooks().size(), currentUserResonse.getBooks().size());
        Assert.assertEquals(expectedCreateUserResponse.getBooks().get(0), currentUserResonse.getBooks().get(0));
    }

    public DeleteBookRequest setDeleteBookRequest(String userId, String isbn){
        DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        deleteBookRequest.setIsbn(isbn);
        deleteBookRequest.setUserId(userId);

        return deleteBookRequest;
    }

    public Response deleteABookFromCollection(DeleteBookRequest deleteBookRequest, String token) throws IOException, URISyntaxException {
        return RestResource.delete(BookApiPaths.DELETE_A_BOOkS, deleteBookRequest, token);
    }
}
