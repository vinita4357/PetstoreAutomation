package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.*;
import static org.hamcrest.Matchers.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import io.restassured.response.Response;

public class UserEndPoints2 {
	
	static ResourceBundle geturl() {
		ResourceBundle routes=ResourceBundle.getBundle("route");
		return routes;
	}
	
	

			
			
	
	
public static Response Createuser(User payload) {
	String post_url=geturl().getString("post_url");
			System.out.print(post_url);
			
	Response response=given().contentType("application/json").body(payload).when().post(post_url);
	
	return response;
}
public static Response readuser(String username) {
	String get_url=geturl().getString("get_url");
	Response response=given().contentType("application/json").pathParam("username", username).when().get(get_url);
	
	return response;
}
public static Response updateuser(String username,User payload) {
	String update_url=geturl().getString("update_url");
	Response response=given().contentType("application/json").pathParam("username", username).when().put(update_url);
	
	return response;
}

public static Response deleteuser(String username) {
	String delete_url=geturl().getString("delete_url");
	Response response=given().contentType("application/json").pathParam("username", username).when().delete(delete_url);
	
	return response;
}
}
