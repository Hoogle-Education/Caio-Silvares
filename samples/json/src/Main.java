import models.User;
import utils.Log4Json;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        User user = new User("email@gmail.com", "John", "Wick", 42, "babayaga");
        System.out.println(Log4Json.serialize(user));
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