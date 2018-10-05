import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    private static ArrayList<String> loadedInput;
    private static String dir = "./";
    private static String filename = "input.txt";

    public static void main(String[] args) {
        try {
            readInput();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Analyzer analyzer = new Analyzer();
        try {
            analyzer.analyze(loadedInput);
        } catch (Exception e) {
            //TODO Exceptions
            e.printStackTrace();
        }

    }

    private static void readInput() throws IOException {
        loadedInput = new ArrayList<>();

        Files.lines(Paths.get(dir + filename))
                .forEach(
                        line -> loadedInput.add(line));

    }
}
