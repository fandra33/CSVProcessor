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
            // Split and trim headers
            String[] headerArray = first.split(",", -1);
            List<String> trimmedHeaders = new ArrayList<>();
            for (String header : headerArray) {
                trimmedHeaders.add(header.trim());
            }
            headers = trimmedHeaders;

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);

                // throw error if the row is not complete
                if (values.length != headers.size()) {
                    throw new IOException("Fisierul CSV are randuri invalide");
                }

                // Trim values
                String[] trimmedValues = new String[values.length];
                for (int i = 0; i < values.length; i++) {
                    trimmedValues[i] = values[i].trim();
                }
                CSVRow row = new CSVRow(headers.toArray(new String[0]), trimmedValues);
                rows.add(row);
            }
        }
        return rows;
    }

    public List<CSVRow> getRows() {
        return rows;
    }
}