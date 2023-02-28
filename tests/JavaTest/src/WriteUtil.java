import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WriteUtil {

    public static void main(String[] args) {

        String filename = "file.txt";

        try (var reader = new BufferedReader(new FileReader(filename))) {
            var stringList = reader.lines().toList();
            var stringArrayList = new ArrayList<>(stringList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

