package main.java.common;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {

    public static ArrayList<String[]> readCSV(File csv_file) {
        ArrayList<String[]> fields = new ArrayList<>();
        BufferedReader freader = null;

        try {
            freader = new BufferedReader(new FileReader(csv_file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return fields;
        }

        String currentLine;
        try {
            while((currentLine = freader.readLine()) != null) {
                if(currentLine.equals("")) { //skip empty lines
                    continue;
                }
                fields.add(currentLine.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fields;
    }
}
