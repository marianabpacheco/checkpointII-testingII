import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class ParabankApiTest {



    @Test
    public void accountsOverviewTest(){
        given()
                .when()
                .header("Cookie","JSESSIONID=D92B01F3AE9195385A532B58613C7E30")
                .get("https://parabank.parasoft.com/parabank/overview.htm")
                .then()
                .statusCode(500);
    }

    @Test
    public void accountActivity(){
        given()
                .when()
                .header("Cookie","JSESSIONID=D92B01F3AE9195385A532B58613C7E30")
                .get("https://parabank.parasoft.com/parabank/activity.htm?id=13788")
                .then()
                .statusCode(200);
    }


    @Test
    public void newAccount(){
        given()
                .when()
                .header("Cookie","JSESSIONID=D92B01F3AE9195385A532B58613C7E30")
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12767&newAccountType=1&fromAccountId=13788")
                .then()
                .statusCode(401);
    }

    @Test
    public void transferFunds(){
        given()
                .when()
                .header("Cookie","JSESSIONID=D92B01F3AE9195385A532B58613C7E30")
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13788&toAccountId=18228&amount=100")
                .then()
                .statusCode(401);
    }

    @Test
    public void register(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customer.firstName", "Aaron");
        jsonObject.put("customer.lastName", "Preston");
        jsonObject.put("customer.address.address", "Ap #508-5140 Malesuada St.");
        jsonObject.put("customer.address.city", "Kemerovo Oblast");
        jsonObject.put("customer.address.state", "State");
        jsonObject.put("customer.address.zipCode", "3180-67510");
        jsonObject.put("customer.phoneNumber", "1-895-785-0623");
        jsonObject.put("customer.ssn", " 123456");
        jsonObject.put("customer.username", "usernameAaron3");
        jsonObject.put("customer.password", "123456");
        jsonObject.put("repeatedPassword", "123456");
        System.out.println(jsonObject);

        given()
                .header("Content-type","application/json")
                .body(jsonObject.toString())
                .and()
                .when()
                .post("https://parabank.parasoft.com/parabank/register.htm")
                .then()
                .statusCode(500);
    }

}
