package TP.TP2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class readFile {
    public static void main(String[] args) {
        String filePath = "targets.txt";

        Double[][] res = read(filePath);

//        for (int i = 0; i < res.length; i++) {
//            System.out.println("[ " + res[i][0] + " ; " + res[i][1] + " ]");
//        }
    }

    public static Double[][] read (String filePath) {
        Double[][] res;
        BufferedReader br;
        int cpt = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            ArrayList<String> lines = new ArrayList<String>().addAll(br.lines().toArray());
            res = new Double[(int)lines.size()][2];
            for( String line : lines){
                System.out.println("[ " + res[cpt][0] + " ; " + res[cpt][1] + " ]");
            }


//            while (false) {
//                String[] local =  tmp.split(" ");
//                res[cpt][0] = Double.valueOf(local[0]);
//                res[cpt][1] = Double.valueOf(local[1]);
//                System.out.println("[ " + res[cpt][0] + " ; " + res[cpt][1] + " ]");
//                cpt++;
//                tmp = br.readLine();
//            }
        } catch (IOException e) {
            res = new Double[0][0];
            e.printStackTrace();
        }

        return res;
    }
}
