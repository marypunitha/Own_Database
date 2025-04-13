Absolutely! Here's a clean and informative `README.md` for your **Mini Database System in Java** project:

---

## 📦 Mini Database System (Java)

A lightweight in-memory database system built using pure Java.  
Supports basic database operations like creating tables, inserting data, selecting, updating, deleting records, and saving/loading from a file.

---

### ✨ Features

- ✅ Create tables with specified columns  
- ✅ Insert records into tables  
- ✅ Select all records or filtered ones (`WHERE` clause)  
- ✅ Update records based on conditions  
- ✅ Delete records based on conditions  
- ✅ Save database state to a file  
- ✅ Load database state from a file  

---

### 🛠️ Technologies Used

- Java (Core)
- File I/O
- Collections API (`Map`, `List`, `HashMap`, etc.)

---

### 📁 Project Structure

```
MiniDatabaseSystem/
├── Main.java               // Entry point to test the database
├── SimpleDatabase.java     // Handles multiple tables and global operations
└── Table.java              // Represents individual tables with rows and columns
```

---

### 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/MiniDatabaseSystem.git
   cd MiniDatabaseSystem
   ```

2. Compile the Java files:
   ```bash
   javac Main.java SimpleDatabase.java Table.java
   ```

3. Run the program:
   ```bash
   java Main
   ```

---

### 💾 Sample Output

```
All Students:
{id=1, name=Mary}
{id=2, name=Punitha}

Select where name = Mary:
{id=1, name=Mary}

Updating Mary to Maria...
{id=1, name=Maria}
{id=2, name=Punitha}

Deleting student with id = 2
{id=1, name=Maria}
```

---

### 📚 Save & Load Format

The database saves data in a simple custom text format:

```
Table: students
Columns: id,name
Row: 1,Mary
Row: 2,Punitha
```

---

### 📌 To-Do (for future improvement)

- [ ] Support for data types (e.g., int, string, boolean)
- [ ] SQL-like query parser
- [ ] Basic constraints (e.g., unique, not null)
- [ ] GUI using JavaFX or Swing

---

### 🧑‍💻 Author

**Mary Punitha**  
B.E. Computer Science and Engineering

---

Would you like this saved as a file or customized with your GitHub username/project link?# Own_Database
