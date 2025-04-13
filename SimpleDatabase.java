import java.io.*;
import java.util.*;

public class SimpleDatabase {
    private Map<String, Table> tables = new HashMap<>();

    public void createTable(String name, List<String> columns) {
        tables.put(name, new Table(name, columns));
    }

    public void insert(String tableName, Map<String, String> row) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.insert(row);
        } else {
            System.out.println("Table " + tableName + " doesn't exist.");
        }
    }

    public void selectAll(String tableName) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.selectAll();
        } else {
            System.out.println("Table " + tableName + " doesn't exist.");
        }
    }

    public void selectWhere(String tableName, String column, String value) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.selectWhere(column, value);
        } else {
            System.out.println("Table " + tableName + " doesn't exist.");
        }
    }

    public void updateWhere(String tableName, String column, String value, Map<String, String> updates) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.updateWhere(column, value, updates);
        } else {
            System.out.println("Table " + tableName + " doesn't exist.");
        }
    }

    public void deleteWhere(String tableName, String column, String value) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.deleteWhere(column, value);
        } else {
            System.out.println("Table " + tableName + " doesn't exist.");
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String tableName : tables.keySet()) {
                Table table = tables.get(tableName);
                writer.println("Table: " + tableName);
                writer.println("Columns: " + String.join(",", table.getColumns()));
                for (Map<String, String> row : table.getRows()) {
                    List<String> values = new ArrayList<>();
                    for (String col : table.getColumns()) {
                        values.add(row.getOrDefault(col, ""));
                    }
                    writer.println("Row: " + String.join(",", values));
                }
            }
            System.out.println("Database saved to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            String currentTable = null;
            List<String> columns = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Table: ")) {
                    currentTable = line.substring(7).trim();
                } else if (line.startsWith("Columns: ")) {
                    columns = Arrays.asList(line.substring(9).split(","));
                    createTable(currentTable, columns);
                } else if (line.startsWith("Row: ")) {
                    String[] values = line.substring(5).split(",");
                    Map<String, String> row = new HashMap<>();
                    for (int i = 0; i < columns.size(); i++) {
                        row.put(columns.get(i), values[i]);
                    }
                    insert(currentTable, row);
                }
            }
            System.out.println("Database loaded from " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
