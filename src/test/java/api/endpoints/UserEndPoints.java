package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class UserEndPoints {
	
public static Response Createuser(User payload) {
	
	Response response=given().contentType("application/json").body(payload).when().post(Routes.post_url);
	
	return response;
}
public static Response readuser(String username) {
	Response response=given().contentType("application/json").pathParam("username", username).when().get(Routes.get_url);
	
	return response;
}
public static Response updateuser(String username,User payload) {
	Response response=given().contentType("application/json").pathParam("username", username).when().put(Routes.update_url);
	
	return response;
}

public static Response deleteuser(String username) {
	Response response=given().contentType("application/json").pathParam("username", username).when().delete(Routes.delete_url);
	
	return response;
}
}
