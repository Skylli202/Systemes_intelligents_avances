package TP.TP2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class readFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\jmddu\\IdeaProjects\\Systemes_intelligents_avances\\src\\TP\\TP2\\targets.txt";

        Double[][] res = read(filePath);

//        for (int i = 0; i < res.length; i++) {
//            System.out.println("[ " + res[i][0] + " ; " + res[i][1] + " ]");
//        }
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
            }

        } catch (IOException e) {
            res = new Double[0][0];
            e.printStackTrace();
        }

        return res;
    }
}
