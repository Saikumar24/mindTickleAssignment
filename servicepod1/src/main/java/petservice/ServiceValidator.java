package petservice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.InputStream;

public class ServiceValidator {
    public void validateResponse(Response response){
        Assert.assertTrue(response.toString().contains("200"));
    }

    public void validateStatusResponse(Response response,String status){
        Assert.assertTrue((JsonPath.with((InputStream) response).getString( "$.status")).contains(status));
    }
}
