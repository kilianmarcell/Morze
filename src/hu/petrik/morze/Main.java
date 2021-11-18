package hu.petrik.morze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> morzeKod;

    static {
        try {
            morzeKod = Files.readAllLines(Paths.get("morze.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> morzeAbc;

    static {
        try {
            morzeAbc = Files.readAllLines(Paths.get("morzeabc.txt"));
            morzeAbc.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static HashMap<Character, String> charToMorze = new HashMap<>();
    static HashMap<String, Character> morzeToChar = new HashMap<>();
    static HashMap<String, String> szerzoIdezet = new HashMap<>();

    public static void main(String[] args) throws IOException {

        feladat3();
        feladat4();
        Morze2Szoveg();

    }

    public static void feladat3() {

        System.out.print("3. feladat: A morze abc " + morzeAbc.size() + " db karakter kódját tartalmazza.");

        for (int i = 0; i < morzeAbc.size(); i++) {

            String[] egysor = morzeAbc.get(i).split("\t");

            charToMorze.put(egysor[0].charAt(0), egysor[1]);
            morzeToChar.put(egysor[1], egysor[0].charAt(0));

        }
//
        //System.out.println("Betű\tMorzejel");
//
        //for (Character key : charToMorze.keySet()) {
//
        //    System.out.println(key + "\t\t" + charToMorze.get(key));
//
        //}

    }

    public static void feladat4() {

        System.out.print("4. feladat\nKérem adjon meg egy betűt!: ");

        Scanner s = new Scanner(System.in);

        String beker = s.nextLine();

        boolean voltE = true;

        for (Character k : charToMorze.keySet()) {

            if (k == beker.toUpperCase().charAt(0)) {

                System.out.println("A(z) " + k + " karakter morze kódja: " + charToMorze.get(k));
                voltE = false;

            }

        }

        if (voltE) {

            System.out.println("Nem található a kódtárban ilyen karakter!");

        }

    }

    public static void Morze2Szoveg() {

        String[] tagol = new String[morzeKod.size()];

        for (int i = 0; i < morzeKod.size(); i++) {

            tagol = morzeKod.get(i).split(";");
            String szerzo = tagol[0];
            szerzo.split("   ");

            szerzoIdezet.put(tagol[0], tagol[1]);

        }

    }

}
