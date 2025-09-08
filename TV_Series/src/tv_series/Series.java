/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tv_series;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *
 */

public class Series {
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public void CaptureSeries() {
        System.out.println("\n--- Capture New Series ---");
        System.out.print("Enter Series ID: ");
        String id = input.nextLine();

        System.out.print("Enter Series Name: ");
        String name = input.nextLine();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2-18): ");
            age = input.nextLine();
            try {
                int ageVal = Integer.parseInt(age);
                if (ageVal >= 2 && ageVal <= 18) break;
                else System.out.println("Invalid age. Enter a value between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        String episodes = input.nextLine();

        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        System.out.println("Series details have been successfully saved!\n");
    }

    public void SearchSeries() {
        System.out.println("\n--- Search Series ---");
        System.out.print("Enter Series ID to search: ");
        String id = input.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                System.out.println("Series Found:\n" + series);
                return;
            }
        }
        System.out.println("No series data found with ID: " + id);
    }

    public void UpdateSeries() {
        System.out.println("\n--- Update Series ---");
        System.out.print("Enter Series ID to update: ");
        String id = input.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                System.out.print("Enter new Series Name: ");
                series.SeriesName = input.nextLine();

                String age;
                while (true) {
                    System.out.print("Enter new Age Restriction (2-18): ");
                    age = input.nextLine();
                    try {
                        int ageVal = Integer.parseInt(age);
                        if (ageVal >= 2 && ageVal <= 18) break;
                        else System.out.println("Invalid age. Enter 2-18.");
                    } catch (NumberFormatException e) {
                        System.out.println("Only numbers allowed.");
                    }
                }
                series.SeriesAge = age;

                System.out.print("Enter new Number of Episodes: ");
                series.SeriesNumberOfEpisodes = input.nextLine();

                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("No series found with ID: " + id);
    }

    public void DeleteSeries() {
        System.out.println("\n--- Delete Series ---");
        System.out.print("Enter Series ID to delete: ");
        String id = input.nextLine();
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).SeriesId.equals(id)) {
                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirm = input.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    seriesList.remove(i);
                    System.out.println("Series deleted successfully.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("No series found with ID: " + id);
    }

    public void SeriesReport() {
        System.out.println("\n--- Series Report ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series to display.");
        } else {
            for (SeriesModel series : seriesList) {
                System.out.println(series);
                System.out.println("-------------------------");
            }
        }
    }

    public void ExitSeriesApplication() {
        System.out.println("\nExiting application... Goodbye!");
        System.exit(0);
    }
}

