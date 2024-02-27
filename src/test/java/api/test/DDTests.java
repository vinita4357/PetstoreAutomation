package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="data",dataProviderClass=Dataprovider.class)
	public void testpostuser(String userID,String username,String fname,String lname,String useremail,String pwd,String ph) {
		User userpayload =new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(username);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		Response r=	UserEndPoints.Createuser(userpayload);
		r.then().log().all();
		Assert.assertEquals(r.getStatusCode(),200);
		
		
		
	}
	
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=Dataprovider.class)
	public void deleteuser(String username)
	{
		Response r=		UserEndPoints.deleteuser(username);
		r.then().log().all();
	}

}
