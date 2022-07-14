package TestCases;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.AssertsEnabled;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by monal on 7/13/2022.
 */
public class Test_01_AddStudent {

    @Test
    public void addStudent() {
        JSONObject addStudent = new JSONObject();
        addStudent.put("firstName", "Am2");
        addStudent.put("id",10 );
        addStudent.put("lastName", "Me2");
        addStudent.put("nationality", "US");
        addStudent.put("studentClass", "five");

        given().body(addStudent.toJSONString()).contentType(ContentType.JSON).
                post("http://localhost:9080/studentmgmt/addStudent").
                then().statusCode(200);
    }

    @Test
    public void fetchStudent(){
        JSONObject student = new JSONObject();
        student.put("id",10);
      Response response =  given().body(student.toJSONString()).get("http://localhost:9080/studentmgmt/fetchStudents");
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void deleteStudent() {
        JSONObject student = new JSONObject();
        student.put("id", 10);
        Response response = given().body(student.toJSONString()).get("http://localhost:9080/studentmgmt/fetchStudents");
        Assert.assertEquals(response.getStatusCode(),200);
    }

    public void updateStudent(){
        JSONObject student = new JSONObject();
        student.put("firstName", "Am2");
        student.put("id",10 );
        student.put("lastName", "Me2");
        student.put("nationality", "US");
        student.put("studentClass", "five");

        Response response = given().body(student.toJSONString()).get("http://localhost:9080/studentmgmt/updateStudent");
        Assert.assertEquals(response.statusCode(),200);


    }
}

