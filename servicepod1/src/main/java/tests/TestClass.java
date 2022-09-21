package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import logger.LoggingManager;
import nameservice.NameServiceFactoryClass;
import nameservice.NameServiceValidator;
import nameservice.pojo.NameServiceRequest;
import org.json.JSONObject;
import org.testng.annotations.Test;
import petservice.ServiceFactoryClass;
import petservice.ServiceValidator;
import petservice.pojo.PetServiceRequest;

import java.io.InputStream;

public class TestClass extends LoggingManager {

    NameServiceFactoryClass nameServiceFactoryClass = new NameServiceFactoryClass();
    NameServiceValidator nameServiceValidator = new NameServiceValidator();
    ServiceValidator serviceValidator = new ServiceValidator();

    ServiceFactoryClass serviceFactoryClass = new ServiceFactoryClass();

    private static Response response,updateUserResponse,petCreationResponse,updatePetResponse;

    @Test(dataProvider = "generateUserData",description = "Validate whether a single user is being created in the system")
    public void singleUserCreation(NameServiceRequest nameServiceRequest) {
        Response response = nameServiceFactoryClass.createUsers(nameServiceRequest);
        nameServiceValidator.validateResponse(response);
    }

    @Test(dataProvider = "generateUserData",description = "Validate whether multiple users are being created in the system")
    public void multipleUserCreation(NameServiceRequest nameServiceRequest) {
        response = nameServiceFactoryClass.createUsers(nameServiceRequest);
        nameServiceValidator.validateResponse(response);
    }

    @Test(description = "Validate whether users data are being updated")
    public void updateUser() {
        String userName = JsonPath.with((InputStream) response).getString( "$.userName");
        JSONObject responseBody = (JSONObject) nameServiceFactoryClass.getUser(userName);
        updateUserResponse = nameServiceFactoryClass.updateUsers(responseBody,userName);
        nameServiceValidator.validateResponse(updateUserResponse);
    }

    @Test(description = "Validate whether updated user data are being fetched")
    public void getUpdatedUser() {
        String userName = JsonPath.with((InputStream) updateUserResponse).getString( "$.userName");
        Response response = nameServiceFactoryClass.getUser(userName);
        nameServiceValidator.validateResponse(response);
    }

    @Test(dataProvider = "generatePetData",description = "Validate whether a single pet is being created in the system")
    public void singlePetCreation(PetServiceRequest petServiceRequest) {
        Response response = serviceFactoryClass.createPets(petServiceRequest);
        serviceValidator.validateResponse(response);
    }

    @Test(dataProvider = "generatePetData",description = "Validate whether multiple pets are being created in the system")
    public void multiplePetCreation(PetServiceRequest petServiceRequest) {
        petCreationResponse = serviceFactoryClass.createPets(petServiceRequest);
        serviceValidator.validateResponse(petCreationResponse);
    }

    // As per the assignment, the end point is not mentioned to fetch a particular pet as per their name. Hence, assumed that the endpoint
    // has been wrongly updated
    @Test(dataProvider = "updatePetStatus",description = "Validate whether pets data are being updated")
    public void updatePet(String status) {
        String petName = JsonPath.with((InputStream) petCreationResponse).getString( "$.name");
        JSONObject responseBody = (JSONObject) serviceFactoryClass.getPet(petName);
        updatePetResponse = serviceFactoryClass.updatePets(responseBody,petName,status);
        serviceValidator.validateResponse(updatePetResponse);
    }

    @Test(dataProvider = "updatePetStatus",description = "Validate whether pets data are being fetched as per the status")
    public void getPetByStatus(String status) {
        Response response = serviceFactoryClass.getPetByStatus(status);
        serviceValidator.validateStatusResponse(response,status);
    }
}