package q.rest.vehicle.helper;

public class AppConstants {

    private final static String WEBSITE_BASE_URL = "http://qtest.fareed9.com/";
    private static final String USER_SERVICE = "http://localhost:8081/service-q-user/rest/internal/api/v2/";
    private static final String IMAGE_SERVICE = "http://localhost:8081/q-images/rest/internal/api/v2/";
    private static final String CUSTOMER_SERVICE = "http://localhost:8081/service-q-customer/rest/internal/api/v2/";
    private static final String PUBLIC_CUSTOMER_SERVICE = "http://localhost:8081/service-qetaa-customer/rest/api/v2/";
    private final static String PUBLIC_VEHICLE_SERVICE = "http://localhost:8081/service-qetaa-vehicle/rest/api/v1/";
    public static final String CUSTOMER_MATCH_TOKEN = CUSTOMER_SERVICE + "match-token";
    public static final String USER_MATCH_TOKEN = USER_SERVICE + "match-token";
    public static final String USER_MATCH_TOKEN_WS = USER_SERVICE + "match-token/ws";
    public static final String POST_QUOTATION_VIN_IMAGE = IMAGE_SERVICE + "quotation-vin";
    public static final String POST_QUOTATION_ITEM_IMAGE = IMAGE_SERVICE + "quotation-item";


}
