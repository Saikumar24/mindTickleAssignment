package petservice;

import apiclient.ApiClient;
import apicore.ApiCore;
import io.restassured.response.Response;
import petservice.pojo.PetServiceRequest;

import java.util.HashMap;
import java.util.Map;

public class ServiceHelpers extends ApiClient {
    protected Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(ServiceConstants.CONTENT_TYPE, "application/json");
        return headers;
    }

    /**
     * Create the new pet using POST call
     * @param petServiceRequest Request body for creating new pet
     * @return API Response
     */
    public Response createPets(PetServiceRequest petServiceRequest){
        return ApiCore.postRequest(ServiceEndpoints.CREATE_PET_POST_CALL,null,getHeaders(),petServiceRequest);
    }

    /**
     * Get the existing pet using GET call
     * @param petName pet name to be fetched
     * @return API Response
     */

    public Response getPet(String petName){
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("name",petName);
        return ApiCore.getRequestPathParams(ServiceEndpoints.GET_PET_CALL,pathParams);
    }

    /**
     * Get the existing pet using GET call using the pet status
     * @param status pet status
     * @return API Response
     */
    public Response getPetByStatus(String status){
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("status",status);
        return ApiCore.getRequestPathParams(ServiceEndpoints.GET_PET_STATUS_CALL,queryParams);
    }

    /**
     * Update the existing pet using PUT call
     * @param dataObject Request body for updating the existing pet
     * @param petName pet name to be updated with new values
     * @return API Response
     */
    public Response updatePet(PetServiceRequest dataObject, String petName){
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("name",petName);
        return ApiCore.putRequestWithPathParams(ServiceEndpoints.GET_PET_CALL,null,getHeaders(),dataObject,pathParams);
    }
}
