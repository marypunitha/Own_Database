package com.example.package1;

import java.util.*;

public class Table {
    private String name;
    private List<String> columns;
    private List<Map<String, String>> rows = new ArrayList<>();

    public Table(String name, List<String> columns) {
        this.name = name;
        this.columns = columns;
    }

  

    public void selectAll() {
        for (Map<String, String> row : rows) {
            System.out.println(row);
        }
    }
    public void insert(Map<String, String> row) {
        rows.add(new HashMap<>(row)); // Clone to make it mutable
    }

    public void selectWhere(String column, String value) {
        for (Map<String, String> row : rows) {
            if (value.equals(row.get(column))) {
                System.out.println(row);
            }
        }
    }

    public void updateWhere(String column, String value, Map<String, String> updates) {
        for (Map<String, String> row : rows) {
            if (value.equals(row.get(column))) {
                for (String key : updates.keySet()) {
                    row.put(key, updates.get(key));
                }
            }
        }
    }

    public void deleteWhere(String column, String value) {
        rows.removeIf(row -> value.equals(row.get(column)));
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<Map<String, String>> getRows() {
        return rows;
    }
}
