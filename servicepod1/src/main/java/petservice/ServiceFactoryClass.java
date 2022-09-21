package petservice;

import io.restassured.response.Response;
import org.json.JSONObject;
import petservice.pojo.PetServiceRequest;

public class ServiceFactoryClass {
    ServiceHelpers serviceHelper = new ServiceHelpers();

    /**
     * Create the new pet
     * @param petServiceRequest Request body for creating new pet
     * @return API Response
     */
    public Response createPets(PetServiceRequest petServiceRequest){
        return serviceHelper.createPets(ServiceEntities.createPets(petServiceRequest));
    }

    /**
     * Get the existing pet
     * @param petName pet name to be fetched
     * @return API Response
     */
    public Response getPet(String petName){
        return serviceHelper.getPet(petName);
    }

    /**
     * Get the existing pet using pet status
     * @param status pet status to be fetched
     * @return API Response
     */
    public Response getPetByStatus(String status){
        return serviceHelper.getPetByStatus(status);
    }


    /**
     * Update the existing pet
     * @param dataObject Request body for updating the existing pet
     * @param petName pet name to be updated with new values
     * @param status pet status to be updated
     * @return API Response
     */
    public Response updatePets(JSONObject dataObject, String petName,String status){
        return serviceHelper.updatePet(ServiceEntities.updatePet(dataObject,status),petName);
    }
}
