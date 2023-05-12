import models.Car;
import models.User;
import utils.Log4Json;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("email@gmail.com", "John", "Wick", 42, "babayaga");
        Car car = new Car("XYZ3 - 45", "Maria", 2019, "111.222-345");
        System.out.println(Log4Json.toJson(user));
        System.out.println(Log4Json.toJson(car));
    }
}

/*JSON: javascript object notation
{
    "username" : "@jj321",
    "name" : "John",
    "age": 20,
    "address" : {
        "city": "New York",
        "country": "US"
    }
*/

/*  JSON without format
    "username":"@jj321","name" : "John","age": 20,"address" : {"city": "New York","country": "US"}
 */