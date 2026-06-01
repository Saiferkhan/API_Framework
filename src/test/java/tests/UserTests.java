package tests;

import base.BaseClass;
import endpoints.Endpoint;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import payload.UserPayload;

import static io.restassured.RestAssured.given;

public class UserTests extends BaseClass {
   @Test(priority = 1)
    public void createUserTest() {
        UserPayload pload = new UserPayload();
        
        pload.setId("0");
        pload.setTitle("QA");
        pload.setPrice("500");
        pload.setDescription("Api automation");
        pload.setCategory("Test Engineer");
        pload.setImage("http://example.com");
      

        Response response = given()
                .contentType(ContentType.JSON)
                .body(pload)

                .when()
                .post(Endpoint.createUser);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);

    }
   @Test(priority=2)
    public void getProductsList() {
    	
     given()
                

                .when()
                .get(Endpoint.getUser)

        .then().statusCode(200).log().all();

       // Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority=3)
    public void updateProduct() {
    	UserPayload pload =new UserPayload();
    	
    	
    	pload.setPrice("200");
		pload.setId("0");
        pload.setTitle("QA");
        pload.setDescription("Api automation");
        pload.setCategory("Test Engineer");
        pload.setImage("http://example.com");
        
     given()
     .body(pload)
                
                .when()
                .put(Endpoint.updateUser)

        .then().statusCode(200).log().all();
    }
    
   @Test
    public void deleteUserAccount() {
    	//UserPayload pload=new UserPayload();
    	
    	Response res=given()
    			.contentType(ContentType.JSON)
                //.body(pload)
    			//.queryParam("id",1)

   		.when()
   				.delete(Endpoint.deleteUser)
    	.then()
        .statusCode(200)
        .log().all()
        .extract().response();
   		
    	
    	String actualmsg=res.jsonPath().getString("title");
    	System.out.print("actmsg is :"+actualmsg);
    	assertEquals(actualmsg, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
    	
//   		.then()
//   				.statusCode(200).log().all();
    }
}
