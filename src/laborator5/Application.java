package laborator5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            printSmallTextFile("in.txt");
            System.out.println("\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void printSmallTextFile(String fileName) throws IOException {
        System.out.println("Using Files.readAllLines:");

        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        for(String line: allLinesInMemory) {
            System.out.println(line+"\n");


            String[] words = line.split("\\.");
            for(String w: words) {
                System.out.print(w);
            }
        }

    }

}
