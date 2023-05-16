package impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileInput {

    /**
     * Reads an array of integers from a resource file.
     * @param path Path to the file within the resources folder.
     * @return Array of integers.
     */
    public static int[] readIntsFromFile(String path) {
        File file = new File("");
        var rootPath = file.getAbsolutePath();
        var basePath = List.of("src", "main", "resources")
                .stream()
                .reduce(File.separator, (acc, folder) -> acc + folder + File.separator);

        path = rootPath + basePath + path;
        var integers = new int[0];
        try {
            var lines = Files.readAllLines(Path.of(path));
            integers = lines.stream().mapToInt(Integer::parseInt).toArray();
        } catch (IOException ioException) {
            System.err.println("Invalid file... the integers array is empty");
        }

        return integers;
    }
}
