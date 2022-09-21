package apicore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiCore {
    public ApiCore(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    /**
     * Get Request
     *
     * @param endPoint endPoint
     * @return API Response
     */
    public static Response getRequest(String endPoint) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(endPoint)
                .then()
                .extract().response();
    }

    /**
     * GET Request with Path Params
     *
     * @param endPoint endPoint
     * @param pathParams Path params being stored in form of map
     * @return API Response
     */
    public static Response getRequestPathParams(String endPoint, Map<String, String> pathParams) {
        return given()
                .contentType(ContentType.JSON)
                .pathParams(pathParams)
                .when()
                .get(endPoint)
                .then()
                .extract().response();
    }

    /**
     * GET Request with Query Params
     *
     * @param endPoint endPoint
     * @param queryParams Query params being stored in form of map
     * @return API Response
     */
    public Response getRequestQueryParams(String endPoint, Map<String,String> queryParams) {
        return given()
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .get(endPoint)
                .then()
                .extract().response();
    }

    /**
     * GET Request with Query and Path Params
     *
     * @param endPoint endPoint
     * @param queryParams Query params being stored in form of map
     * @param pathParams Path params being stored in form of map
     * @return API Response
     */
    public Response getRequestQueryPathParams(String endPoint, Map<String,String> queryParams,Map<String,String> pathParams) {
        return given()
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .pathParams(pathParams)
                .when()
                .get(endPoint)
                .then()
                .extract().response();
    }


    /**
     * POST api to make request with parameters
     *
     * @param endPoint  - URL to be inputted for put method
     * @param headerValue - Map formatted list of header values
     * @param paramValue  - Map formatted list of param values
     * @param requestBody - Requestbody Object
     * @return response
     */
    public static Response postRequest(String endPoint, Map<String, Object> paramValue, Map<String, Object> headerValue, Object requestBody) {
        RequestSpecification requestApi = RestAssured.given();
        if (!paramValue.isEmpty()) {
            requestApi = requestApi.params(paramValue);
        }
        if (!headerValue.isEmpty()) {
            requestApi = requestApi.headers(headerValue);
        }
        return requestApi.body(requestBody.toString()).when().post(endPoint).then().log().all().extract().response();
    }

    /**
     * PUT Api to make the request with the body params
     *
     * @param apiBaseUrl  - URL to be inputted for put method
     * @param headerValue - Map formatted list of header values
     * @param paramValue  - Map formatted list of param values
     * @param requestBody - Requestbody Object
     * @return response
     */
    public static Response putRequest(String apiBaseUrl, Map<String, Object> paramValue, Map<String, Object> headerValue, Object requestBody) {
        RequestSpecification requestApi = RestAssured.given();
        if (!paramValue.isEmpty()) {
            requestApi = requestApi.params(paramValue);
        }
        if (!headerValue.isEmpty()) {
            requestApi = requestApi.headers(headerValue);
        }
        return requestApi.body(requestBody.toString()).when()
                .put(apiBaseUrl)
                .then().log().all().extract().response();
    }

    /**
     * PUT Api to make the request with the body params
     *
     * @param apiBaseUrl  - URL to be inputted for put method
     * @param headerValue - Map formatted list of header values
     * @param paramValue  - Map formatted list of param values
     * @param requestBody - Requestbody Object
     * @param pathParams Path params being stored in form of map
     * @return response
     */
    public static Response putRequestWithPathParams(String apiBaseUrl, Map<String, Object> paramValue, Map<String, Object> headerValue, Object requestBody,Map<String,String> pathParams) {
        RequestSpecification requestApi = RestAssured.given();
        if (!paramValue.isEmpty()) {
            requestApi = requestApi.params(paramValue);
        }
        if (!headerValue.isEmpty()) {
            requestApi = requestApi.headers(headerValue);
        }
        return requestApi.body(requestBody.toString()).pathParams(pathParams).when()
                .put(apiBaseUrl)
                .then().log().all().extract().response();
    }
}
