package apis.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class Builder {
    static RequestSpecification getRequestSpec() throws IOException, URISyntaxException {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.getInstance().getBaseUri())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }
}
