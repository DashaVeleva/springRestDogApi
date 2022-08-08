import com.dashaveleva.rest.entity.Dog;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;
import static javax.servlet.SessionTrackingMode.URL;

public class ControllerTest {

    private final static String URL = "http://localhost:8080/api/dogs";

    @Test
    public void testGetOneDog() {

        Dog dog = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/1")
                .then().log().all()
                .extract().as(Dog.class);


    }

    @Test
    public void testGetAllDogs() {

        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());

        List<Dog> dogs = given()
                .when()
                .get()
                .then().log().all()
                .extract().body().jsonPath().getList(".", Dog.class);

        dogs.forEach(x -> Assert.assertTrue(x.getName().contains(x.getName())));

    }

    @Test
    public void testSuccessPost() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        int id = 999;
        String name = "Sharic";
        LocalDate dateOfBirth = null;
        int height = 45;
        int weight = 55;

        Dog dog = new Dog(999, "Sharic", null, 45, 55);

        Dog dogTest = given()
                .body(dog)
                .when().post()
                .then().log().all()
                .extract().as(Dog.class);
        Assert.assertNotNull(dogTest);
        Assert.assertEquals(name, dogTest.getName());
        Assert.assertEquals(dateOfBirth, dogTest.getDateOfBirth());
        Assert.assertEquals(height, dogTest.getHeight());
        Assert.assertEquals(weight, dogTest.getWeight());

    }

    @Test
    public void testUnSuccessPost() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationError400());

        Dog dog = null;

        Dog dogTest = given()
                .body(dog)
                .when().post()
                .then().log().all()
                .extract().as(Dog.class);


    }


}



