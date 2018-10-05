import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    static ArrayList<String> loadedInput;
    static String dir = "./";
    static String filename = "input.txt";

    public static void main(String[] args) {
        try {
            readInput();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


    }

    public static void readInput() throws IOException {
        loadedInput = new ArrayList<>();

        Files.lines(Paths.get(dir + filename))
                .forEach(
                        line -> loadedInput.add(line));

    }
}
