package petservice;

import org.testng.annotations.DataProvider;
import petservice.pojo.Category;
import petservice.pojo.PetServiceRequest;
import petservice.pojo.Tags;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceDataProvider {

    /**
     * Data Provider for creation of pets
     * @return Object[][]
     */

    @DataProvider(name = "generatePetData")
    protected Object[][] generatePetData(Method method) {
        SecureRandom rand = new SecureRandom();
        if ("singlePetCreation".equals(method.getName())) {
            Category category = Category.builder().id(rand.nextInt()).name(ServiceConstants.NAME).build();
            Tags tags = Tags.builder().id(rand.nextInt()).name(ServiceConstants.NAME).build();
            PetServiceRequest petServiceRequest = PetServiceRequest.builder().id(rand.nextInt()).category(category).name(ServiceConstants.NAME + rand.nextInt()).photoUrls(Collections.singletonList(ServiceConstants.PHOTO_URLS))
                    .tags(Collections.singletonList(tags)).status(ServiceConstants.STATUS_AVAILABLE).build();
            return new Object[][]{{petServiceRequest}};
        } else if ("multiplePetCreation".equals(method.getName())) {
                List<PetServiceRequest> petServiceRequests = new ArrayList<>();
                for(int i=0; i < 3;i++){
                    Category category = Category.builder().id(rand.nextInt()).name(ServiceConstants.NAME).build();
                    Tags tags = Tags.builder().id(rand.nextInt()).name(ServiceConstants.NAME).build();
                    PetServiceRequest petServiceRequest = PetServiceRequest.builder().id(rand.nextInt()).category(category).name(ServiceConstants.NAME + rand.nextInt()).photoUrls(Collections.singletonList(ServiceConstants.PHOTO_URLS))
                            .tags(Collections.singletonList(tags)).status(ServiceConstants.STATUS_AVAILABLE).build();
                    petServiceRequests.add(petServiceRequest);
                }
                return new Object[][]{{petServiceRequests}};
            }
        return new Object[0][];
    }

    /**
     * Data Provider for updating the status of pets
     * @return Object[][]
     */

    @DataProvider(name = "updatePetStatus")
    protected Object[][] updatePetStatus() {
            return new Object[][]{{"available"},{"pending"},{"sold"}};
    }
}
