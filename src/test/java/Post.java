import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post {

    @Test
    void RegistrationSuccessful()
    {

        //Especificando base URI
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();


        //Request paylaod com post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("name","test");
        requestParams.put("salary","123");
        requestParams.put("age","23");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // isso coloca os dados acima no request

        //Response object
        Response response=httpRequest.request(Method.POST,"/create");


        //imprimindo resposta no console
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //validação do status code
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);
        

    }


}