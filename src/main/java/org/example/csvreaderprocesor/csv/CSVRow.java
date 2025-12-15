package org.example.csvreaderprocesor.csv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVRow {
    private Map<String, String> data;

    public CSVRow(String[] headers, String[] values) {
        data = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            data.put(headers[i], values[i]);
        }
    }

    public String getString(String column) { return data.get(column); }
    public int getInt(String column) { return Integer.parseInt(data.get(column)); }
    public double getDouble(String column) { return Double.parseDouble(data.get(column)); }

    public Map<String, String> getData() {
        return data;
    }
//    public ArrayList<String> getHeaders() {
//        ArrayList<String> headers = new ArrayList<>();
//        for (String key : data.keySet()) {
//            headers.add(key);
//        }
//        return headers;
//    }

}
