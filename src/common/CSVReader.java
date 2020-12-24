package common;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {

    static ArrayList<String[]> readCSV(File csv_file) {
        ArrayList<String[]> fields = new ArrayList<>();
        BufferedReader freader = null;

        try {
            freader = new BufferedReader(new FileReader(csv_file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String currentLine = null;
        try {
            while((currentLine = freader.readLine()) != null) {
                fields.add(currentLine.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fields;
    }


    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        File csv = new File("resources/simple_csv.csv");
        ArrayList<String[]> result = CSVReader.readCSV(csv);
        for(String[] strings : result) {
            for(String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }
}
