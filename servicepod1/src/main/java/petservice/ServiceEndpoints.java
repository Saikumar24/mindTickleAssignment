package petservice;

public class ServiceEndpoints {

    static final String CREATE_PET_POST_CALL = "/pet";


    // As per the assignment, the end point is not mentioned to fetch a particular pet as per their name. Hence, assumed that the endpoint
    // has been wrongly updated
    static final String GET_PET_CALL = "/pet/{name}";

    static final String GET_PET_STATUS_CALL = "/pet/findByStatus";
}
