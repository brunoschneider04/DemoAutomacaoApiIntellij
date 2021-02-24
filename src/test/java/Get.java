import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get
{
    @Test
    void getweatherDetails()
    {
        //Especificando a base URI
        RestAssured.baseURI="https://deckofcardsapi.com/api";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET,"/deck/regwfz1v2jan/shuffle/");

        //imprimindo resposta no console
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //validação do status code
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //validação do status line
        String statusLine=response.getStatusLine();
        System.out.println("Status line is:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

}

