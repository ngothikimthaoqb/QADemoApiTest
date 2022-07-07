package apis.helpers;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.URISyntaxException;

import static apis.helpers.Builder.getRequestSpec;
import static apis.helpers.Builder.getResponseSpec;
import static io.restassured.RestAssured.given;
public class RestResource {
    public static Response post(String path, Object params, String token) throws IOException, URISyntaxException {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(params)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }


    public static Response get(String path, String token) throws IOException, URISyntaxException {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response put(String path, Object params, String token) throws IOException, URISyntaxException {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(params)
                .when()
                .put(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
    public static Response delete(String path, Object params, String token) throws IOException, URISyntaxException {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(params)
                .when()
                .delete(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}
