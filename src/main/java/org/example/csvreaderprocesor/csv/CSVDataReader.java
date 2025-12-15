package org.example.csvreaderprocesor.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
 Fixed CSVDataReader:
 - use ArrayList<> for fields
 - readCSV(...) now returns List<CSVRow>
 - initialize/clear rows before populating
 - removed stray semicolon
*/
public class CSVDataReader {
    private List<String> headers = new ArrayList<>();
    private List<CSVRow> rows = new ArrayList<>();

    public List<String> getHeaders() {
        return Collections.unmodifiableList(headers);
    }

    public int getHeaderCount() {
        return headers.size();
    }

    public List<CSVRow> readCSV(String path) throws IOException {
        rows = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String first = br.readLine();
            if (first == null) {
                headers = new ArrayList<>();
                return rows;
            }
            headers = Arrays.asList(first.split(",", -1));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                CSVRow row = new CSVRow(headers.toArray(new String[0]), values);
                rows.add(row);
            }
        }
        return rows;
    }

    public List<CSVRow> getRows() {
        return rows;
    }
}