package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userpayload;
	public Logger logger;
	@BeforeClass
	public void setupdata() {
		faker=new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testpostuser() {
		logger.info("-------------creating user-----------");
	Response r=	UserEndPoints.Createuser(userpayload);
	r.then().log().all();
	Assert.assertEquals(r.getStatusCode(),200);
	logger.info("------------- user created-----------");
	}
	
	@Test(priority=2)
	public void getuserbyname() {
		Response r=		UserEndPoints.readuser(this.userpayload.getUsername());
		r.then().log().all();
	}
	
	@Test(priority=3)
	public void updateusername() {
		logger.info("-------------updating user-----------");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		Response r=		UserEndPoints.updateuser(this.userpayload.getUsername(),userpayload);
		r.then().log().all();
	}
	
	@Test(priority=4)
	public void deleteusername() {
		logger.info("-------------deleting  user-----------");
		Response r=		UserEndPoints.deleteuser(this.userpayload.getUsername());
		r.then().log().all();
		
	
	}

}
