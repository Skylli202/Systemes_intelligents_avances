package TP.TP2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readFile {
    private static String filePathJerome = "C:\\Users\\jmddu\\IdeaProjects\\Systemes_intelligents_avances\\src\\TP\\TP2\\targets.txt";
    private static String filePathElouan = "C:\\Users\\anakin\\Documents\\GitHub\\Systemes_intelligents_avances\\src\\TP\\TP2\\targets.txt";


    public readFile() {
    }

    public static Double[][] read (String filePath) {
        Double[][] res;
        ArrayList<String> lines = new ArrayList<>();
        int cpt = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            Object[] linesObj = br.lines().toArray();

            for ( Object str : linesObj) {
                lines.add((String) str);
            }

            res = new Double[lines.size()][2];

            for( String line : lines) {
                String[] local =  line.split(" ");
                res[cpt][0] = Double.valueOf(local[0]);
                res[cpt][1] = Double.valueOf(local[1]);
                System.out.println("[ " + res[cpt][0] + " ; " + res[cpt][1] + " ]");
                cpt++;
            }

        } catch (IOException e) {
            res = new Double[0][0];
            e.printStackTrace();
        }

        return res;
    }
}
