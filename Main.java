

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SimpleDatabase db = new SimpleDatabase();

        // Create table
        db.createTable("students", List.of("id", "name"));

        // Insert rows
        db.insert("students", Map.of("id", "1", "name", "Mary"));
        db.insert("students", Map.of("id", "2", "name", "Punitha"));

        // Select all
        System.out.println("All Students:");
        db.selectAll("students");

        // Select where
        System.out.println("Select where name = Mary:");
        db.selectWhere("students", "name", "Mary");

        // Update
        System.out.println("Updating Mary to Maria...");
        db.updateWhere("students", "name", "Mary", Map.of("name", "Maria"));

        db.selectAll("students");

        // Delete
        System.out.println("Deleting student with id = 2");
        db.deleteWhere("students", "id", "2");

        db.selectAll("students");

        // Save
        db.saveToFile("database.txt");

        // Load into a new instance
        System.out.println("\nLoading from file into a new database...");
        SimpleDatabase db2 = new SimpleDatabase();
        db2.loadFromFile("database.txt");

        System.out.println("Loaded Students Table:");
        db2.selectAll("students");
    }
}
