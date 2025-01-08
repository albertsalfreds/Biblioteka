package main;

import java.io.*;
import java.util.HashMap;

public class Dati {
    private final HashMap<String, String> logininfo = new HashMap<>();

    public Dati() {
        try (BufferedReader br = new BufferedReader(new FileReader("loginfo.txt"))) {
            br.lines()
                .map(line -> line.split("=")) //sadalitajs
                .filter(parts -> parts.length == 2)
                .forEach(parts -> logininfo.put(parts[0].trim(), parts[1].trim()));
        } catch (IOException e) {
            System.err.println("Error reading loginfo.txt: " + e.getMessage());
        }
    }


    public HashMap<String, String> getLoginInfo() {
        return logininfo;
    }
}
