package nameservice;

import io.restassured.response.Response;
import nameservice.pojo.NameServiceRequest;
import org.json.JSONObject;

public class NameServiceFactoryClass {
    NameServiceHelpers nameServiceHelper = new NameServiceHelpers();

    /**
     * Create the new user
     * @param nameServiceRequest Request body for creating new user
     * @return API Response
     */
    public Response createUsers(NameServiceRequest nameServiceRequest){
        return nameServiceHelper.createUsers(NameServiceEntities.createUsers(nameServiceRequest));
    }

    /**
     * Update the existing user
     * @param dataObject Request body for updating the existing user
     * @param userName user name to be updated with new values
     * @return API Response
     */
    public Response updateUsers(JSONObject dataObject,String userName){
        return nameServiceHelper.updateUser(NameServiceEntities.updateUser(dataObject),userName);
    }

    /**
     * Get the existing user
     * @param userName user name to be fetched
     * @return API Response
     */
    public Response getUser(String userName){
        return nameServiceHelper.getUser(userName);
    }
}
