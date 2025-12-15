package org.example.csvreaderprocesor.csv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<CSVRow> readCSV(String filename) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] headers = reader.readNext();
            List<CSVRow> rows = new ArrayList<>();

            String[] line;
            while ((line = reader.readNext()) != null) {
                rows.add(new CSVRow(headers, line));
            }
            return rows;
        }
    }
}
