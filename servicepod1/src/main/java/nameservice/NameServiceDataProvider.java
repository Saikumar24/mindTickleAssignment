package nameservice;

import nameservice.pojo.NameServiceRequest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class NameServiceDataProvider {
    /**
     * Data Provider for creation of users
     * @return Object[][]
     */

    @DataProvider(name = "generateUserData")
    protected Object[][] generateUserData(Method method) {
        SecureRandom rand = new SecureRandom();
        if ("singleUserCreation".equals(method.getName())) {
            NameServiceRequest nameServiceRequest = NameServiceRequest.builder().id(rand.nextInt()).username(NameServiceConstants.USER_NAME + rand.nextInt()).firstName(NameServiceConstants.FIRST_NAME + rand.nextInt())
                    .lastName(NameServiceConstants.LAST_NAME + rand.nextInt()).email(NameServiceConstants.EMAIL_ID + rand.nextInt() + NameServiceConstants.EMAIL_ID_DOMAIN)
                    .password(NameServiceConstants.PASSWORD).phone(NameServiceConstants.PHONE_NUMBER).userStatus(rand.nextInt()).build();
            return new Object[][]{{nameServiceRequest}};
        } else if ("multipleUserCreation".equals(method.getName())) {
                List<NameServiceRequest> nameServiceRequests = new ArrayList<>();
                for(int i=0; i < 3;i++){
                    NameServiceRequest nameServiceRequest = NameServiceRequest.builder().id(rand.nextInt()).username(NameServiceConstants.USER_NAME+rand.nextInt()).firstName(NameServiceConstants.FIRST_NAME+rand.nextInt())
                            .lastName(NameServiceConstants.LAST_NAME+ rand.nextInt()).email(NameServiceConstants.EMAIL_ID+rand.nextInt()+ NameServiceConstants.EMAIL_ID_DOMAIN)
                            .password(NameServiceConstants.PASSWORD).phone(NameServiceConstants.PHONE_NUMBER).userStatus(rand.nextInt()).build();
                    nameServiceRequests.add(nameServiceRequest);
                }
                return new Object[][]{{nameServiceRequests}};
            }
        return new Object[0][];
    }
}
