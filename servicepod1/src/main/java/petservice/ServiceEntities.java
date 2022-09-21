package petservice;

import org.json.JSONArray;
import org.json.JSONObject;
import petservice.pojo.Category;
import petservice.pojo.PetServiceRequest;
import petservice.pojo.Tags;

import java.util.List;

public class ServiceEntities {

    /**
     * Create the new pet creation request body
     * @param dataObject Test data object
     * @return NameServiceRequest Body
     */
    static PetServiceRequest createPets(Object dataObject){
        JSONArray data = new JSONArray(dataObject);
        PetServiceRequest petServiceRequest = null;
        for(int i=0; i < data.length();i++){
            Category category = Category.builder().id((Integer) data.getJSONObject(i).get("$.category.id")).name((String) data.getJSONObject(i).get("$.category.name")).build();
            Tags tags = Tags.builder().id((Integer) data.getJSONObject(i).get("$.tags.id")).name((String) data.getJSONObject(i).get("$.tags.name")).build();
            petServiceRequest = new PetServiceRequest().builder().id((Integer) data.getJSONObject(i).get("id")).category(category).name((String) data.getJSONObject(i).get("name")).photoUrls((List<String>) data.getJSONObject(i).get("photoUrls"))
                    .tags((List<Tags>) tags).status((String) data.getJSONObject(i).get("status")).build();
        }
        return petServiceRequest;
    }

    /**
     * Create the update pet request body
     * @param dataObject Test data object
     * @param status pet status to be updated
     * @return NameServiceRequest Body
     */
    static PetServiceRequest updatePet(JSONObject dataObject,String status){
        Category category = Category.builder().id((Integer) dataObject.get("$.category.id")).name((String) dataObject.get("$.category.name")).build();
        Tags tags = Tags.builder().id((Integer) dataObject.get("$.tags.id")).name((String) dataObject.get("$.tags.name")).build();
        return new PetServiceRequest().builder().id((Integer) dataObject.get("id")).category(category).name((String) dataObject.get("name")).photoUrls((List<String>) dataObject.get("photoUrls"))
                .tags((List<Tags>) tags).status(status).build();
    }
}
