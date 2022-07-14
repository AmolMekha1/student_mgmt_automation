import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


/**
 * Created by monal on 7/13/2022.
 */
public class Test_01_AddStudent {

    @Test
    public void AddStudent() {
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
    public void FetchStudent(){
        JSONObject student = new JSONObject();
        student.put("id",10);
      Response response =  given().body(student.toJSONString()).get("http://localhost:9080/studentmgmt/fetchStudents");
        System.out.println();
        System.out.println(response.toString());
    }
}

