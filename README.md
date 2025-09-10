#  TV Series Management Application

## Overview
This is a **Java console application** developed for the **PROG6112 Practical Assignment 1**.  
The application allows a TV streaming company to manage its TV series by capturing, searching, updating, deleting, and reporting on series stored in memory.  
It also includes **JUnit tests** to validate that the code functions as intended.

---

##  Features
- **Capture Series**: Add a new TV series (ID, name, age restriction, number of episodes).
- **Validation**: Age restriction must be a number between **2 and 18**.
- **Search Series**: Find a series by its ID.
- **Update Series**: Edit an existing series’ details.
- **Delete Series**: Remove a series from the system (with confirmation).
- **Series Report**: Display all captured series.
- **Exit**: Safely close the application.

---

---

## How to Run
1. Open the project in **NetBeans** (or any Java IDE).  
2. Ensure **JDK 17 or later** is installed.  
3. Run the `Main.java` file.  
4. Use the menu options to interact with the program.  

---

##  Unit Tests
JUnit tests are provided in the `tests` package.  
They cover:
- Searching for an existing series.
- Searching for a non-existent series.
- Updating a series.
- Deleting a series.
- Deleting a non-existent series.
- Valid age restriction.
- Invalid age restriction.

Run tests using **NetBeans Test Runner** or the command:

