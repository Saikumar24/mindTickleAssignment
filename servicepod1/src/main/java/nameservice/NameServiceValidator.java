package nameservice;

import io.restassured.response.Response;
import org.testng.Assert;

public class NameServiceValidator {


    public void validateResponse(Response response){
        Assert.assertTrue(response.toString().contains("200"));
    }
}
