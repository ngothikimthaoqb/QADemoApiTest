package apis;

import models.users.CreateUserResponse;
import models.users.GenerateTokenResponse;
import models.users.UserRequest;
import models.users.UserResponse;
import apis.helpers.RestResource;
import constants.Common;
import constants.UserApiPaths;
import io.restassured.response.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;

public class User {

    public Response createUser(UserRequest userRequest) {
        return RestResource.post(UserApiPaths.CREATE_USER_PATH, userRequest, "");
    }

    public UserRequest setUserRequest(String username, String password) {
        UserRequest userRequest = new UserRequest();
        userRequest.setPassword(password);
        userRequest.setUserName(username);
        return userRequest;
    }

    public void verifyCreateUserSucessfully(Response createUserResponse, UserRequest userRequest) {
        //Verify status code
        Assert.assertEquals(createUserResponse.statusCode(), HttpStatus.SC_CREATED);
        //Verify content type
        Assert.assertEquals(createUserResponse.contentType(), Common.CONTENT_TYPE);

        //Verify data
        CreateUserResponse userResponse = createUserResponse.as(CreateUserResponse.class);
        Assert.assertEquals(userResponse.getUsername(), userRequest.getUserName());
        Assert.assertNotNull(userResponse.getUserID());
    }

    public Response generateToken(UserRequest userRequest) {
        return RestResource.post(UserApiPaths.GENERATE_TOKEN, userRequest, "");
    }

    public void verifyGenerateTokenSuccessfully(Response tokenResponse) {
        Assert.assertEquals(tokenResponse.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(tokenResponse.contentType(), Common.CONTENT_TYPE);
        GenerateTokenResponse generateTokenResponse = tokenResponse.as(GenerateTokenResponse.class);
        Assert.assertNotNull(generateTokenResponse.getToken());
    }

    public Response getUserInformation(String userId, String token) {
        String path = UserApiPaths.GET_USER_INFO.concat(userId);
        return RestResource.get(path, token);
    }

    public void verifyGetUserSuccessfully(Response userInformationResponse, CreateUserResponse expectedUserInfor) {
        UserResponse createUserResponse = userInformationResponse.as(UserResponse.class);
        Assert.assertEquals(userInformationResponse.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(userInformationResponse.contentType(), Common.CONTENT_TYPE);
        Assert.assertNotNull(createUserResponse);
        Assert.assertEquals(createUserResponse.getUserId(), expectedUserInfor.getUserID());
        Assert.assertEquals(createUserResponse.getUsername(), expectedUserInfor.getUsername());
    }
}