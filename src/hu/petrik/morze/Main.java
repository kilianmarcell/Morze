package hu.petrik.morze;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> morzeKod = Files.readAllLines(Paths.get("morze.txt"));
        List<String> morzeAbc = Files.readAllLines(Paths.get("morzeabc.txt"));

        String[] betuk = new String[morzeAbc.size()];
        String[] kod = new String[morzeAbc.size()];

        for (int i = 1; i < morzeAbc.size(); i++) {

            String[] egysor = morzeAbc.get(i).split("\t");
            betuk[i] = egysor[0];
            kod[i] = egysor[1];

        }

    }
}
