package apiclient;

import apicore.ApiCore;

public class ApiClient {

    ApiCore apiCore;

    public ApiClient(){
        apiCore = new ApiCore(getAPIEnvironmentBaseURI());
    }

    /**
     * Return base URI for the Env
     * @return Base URI
     */
    public String getAPIEnvironmentBaseURI() {
        return "https://petstore.swagger.io/";
    }
}
