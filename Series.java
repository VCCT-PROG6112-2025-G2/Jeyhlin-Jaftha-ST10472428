import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Menu
    public void ShowMenu() {
        int choice;
        do {
            System.out.println("\n===== TV SERIES MENU =====");
            System.out.println("1. Capture new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update a series");
            System.out.println("4. Delete a series");
            System.out.println("5. View report");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1: CaptureSeries(); break;
                case 2: SearchSeries(); break;
                case 3: UpdateSeries(); break;
                case 4: DeleteSeries(); break;
                case 5: SeriesReport(); break;
                case 6: ExitSeriesApplication(); break;
                default: System.out.println("Invalid option. Try again.");
            }
        } while (choice != 6);
    }

    // Capture Series
    public void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String id = input.nextLine();

        System.out.print("Enter Series Name: ");
        String name = input.nextLine();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2-18): ");
            age = input.nextLine();
            if (isValidAge(age)) break;
            System.out.println("Invalid age restriction. Try again.");
        }

        System.out.print("Enter Number of Episodes: ");
        String episodes = input.nextLine();

        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        System.out.println("Series successfully saved!");
    }

    // Age validation
    public boolean isValidAge(String age) {
        try {
            int value = Integer.parseInt(age);
            return (value >= 2 && value <= 18);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Search
    public SeriesModel SearchSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) return s;
        }
        return null;
    }

    public void SearchSeries() {
        System.out.print("Enter Series ID to search: ");
        String id = input.nextLine();
        SeriesModel found = SearchSeriesById(id);

        if (found != null) {
            System.out.println("Series Found:");
            System.out.println("ID: " + found.getSeriesId());
            System.out.println("Name: " + found.getSeriesName());
            System.out.println("Age Restriction: " + found.getSeriesAge());
            System.out.println("Episodes: " + found.getSeriesNumberOfEpisodes());
        } else {
            System.out.println("No series found with that ID.");
        }
    }

    // Update
    public void UpdateSeries() {
        System.out.print("Enter Series ID to update: ");
        String id = input.nextLine();
        SeriesModel found = SearchSeriesById(id);

        if (found != null) {
            System.out.print("Enter New Name: ");
            found.setSeriesName(input.nextLine());

            String age;
            while (true) {
                System.out.print("Enter New Age Restriction (2-18): ");
                age = input.nextLine();
                if (isValidAge(age)) break;
                System.out.println("Invalid age restriction. Try again.");
            }
            found.setSeriesAge(age);

            System.out.print("Enter New Number of Episodes: ");
            found.setSeriesNumberOfEpisodes(input.nextLine());

            System.out.println("Series updated successfully.");
        } else {
            System.out.println("Series not found.");
        }
    }

    // Delete
    public void DeleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String id = input.nextLine();
        SeriesModel found = SearchSeriesById(id);

        if (found != null) {
            System.out.print("Are you sure you want to delete? (Y/N): ");
            String confirm = input.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                seriesList.remove(found);
                System.out.println("Series deleted successfully.");
            } else {
                System.out.println("Delete cancelled.");
            }
        } else {
            System.out.println("Series not found.");
        }
    }

    // Delete helper for tests
    public void DeleteSeriesById(String id) {
        SeriesModel found = SearchSeriesById(id);
        if (found != null) seriesList.remove(found);
    }

    // Capture helper for tests
    public void CaptureSeriesForTest(String id, String name, String age, String episodes) {
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
    }

    // Report
    public void SeriesReport() {
        System.out.println("\n===== SERIES REPORT =====");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (SeriesModel s : seriesList) {
                System.out.println("ID: " + s.getSeriesId() +
                        " | Name: " + s.getSeriesName() +
                        " | Age: " + s.getSeriesAge() +
                        " | Episodes: " + s.getSeriesNumberOfEpisodes());
            }
        }
    }

    // Exit
    public void ExitSeriesApplication() {
        System.out.println("Exiting application... Goodbye!");
    }
}

