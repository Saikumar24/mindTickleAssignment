package nameservice;

import apiclient.ApiClient;
import apicore.ApiCore;
import io.restassured.response.Response;
import nameservice.pojo.NameServiceRequest;

import java.util.HashMap;
import java.util.Map;


public class NameServiceHelpers extends ApiClient {


    protected Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(NameServiceConstants.CONTENT_TYPE, "application/json");
        return headers;
    }

    /**
     * Create the new user using POST call
     * @param nameServiceRequest Request body for creating new user
     * @return API Response
     */
    public Response createUsers(NameServiceRequest nameServiceRequest){
        return ApiCore.postRequest(NameServiceEndpoints.CREATE_USERS_POST_CALL,null,getHeaders(),nameServiceRequest);
    }

    /**
     * Update the existing user using PUT call
     * @param dataObject Request body for updating the existing user
     * @param userName user name to be updated with new values
     * @return API Response
     */
    public Response updateUser(NameServiceRequest dataObject,String userName){
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("username",userName);
        return ApiCore.putRequestWithPathParams(NameServiceEndpoints.GET_USERS_CALL,null,getHeaders(),dataObject,pathParams);
    }

    /**
     * Get the existing user using GET call
     * @param userName user name to be fetched
     * @return API Response
     */
    public Response getUser(String userName){
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("username",userName);
        return ApiCore.getRequestPathParams(NameServiceEndpoints.GET_USERS_CALL,pathParams);
    }

}
