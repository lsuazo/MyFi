package common;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {
    static void readCSV(File csv_file) {
        BufferedReader freader = null;
        try {
            freader = new BufferedReader(new FileReader(csv_file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String currentLine = null;
        while (true) {
            try {
                if (!((currentLine = freader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(currentLine);
        }

    }
}
