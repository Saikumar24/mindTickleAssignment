package nameservice;

import nameservice.pojo.NameServiceRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.security.SecureRandom;

public class NameServiceEntities {


    /**
     * Create the new user creation request body
     * @param dataObject Test data object
     * @return NameServiceRequest Body
     */
    static NameServiceRequest createUsers(Object dataObject){
        JSONArray data = new JSONArray(dataObject);
        NameServiceRequest nameServiceRequest = null;
        for(int i=0; i < data.length();i++){
            nameServiceRequest = new NameServiceRequest().builder().id((Integer) data.getJSONObject(i).get("id")).username((String) data.getJSONObject(i).get("username"))
                    .firstName((String) data.getJSONObject(i).get("firstName")).lastName((String) data.getJSONObject(i).get("lastName")).email((String) data.getJSONObject(i).get("email"))
                    .password((String) data.getJSONObject(i).get("password")).phone((String) data.getJSONObject(i).get("phone")).userStatus((Integer) data.getJSONObject(i).get("userStatus")).build();
        }
        return nameServiceRequest;
    }

    /**
     * Create the update user request body
     * @param dataObject Test data object
     * @return NameServiceRequest Body
     */
    static NameServiceRequest updateUser(JSONObject dataObject){
        SecureRandom rand = new SecureRandom();
        return new NameServiceRequest().builder().id((Integer) dataObject.get("id")).username((String) dataObject.get("username"))
                    .firstName(NameServiceConstants.FIRST_NAME+rand.nextInt()).lastName(NameServiceConstants.LAST_NAME+rand.nextInt()).email((String) dataObject.get("email"))
                    .password((String) dataObject.get("password")).phone((String) dataObject.get("phone")).userStatus((Integer) dataObject.get("userStatus")).build();
    }
}
