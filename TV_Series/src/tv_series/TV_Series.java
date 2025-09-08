/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tv_series;
import java.util.Scanner;
/**
 *
 *
 */
public class TV_Series {

 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Series seriesApp = new Series();

        // Startup screen
        System.out.println("*********************************************************");
        System.out.println("***************LATEST SERIES - 2025**********************");
        System.out.println("*********************************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String startChoice = input.nextLine();

        if (!startChoice.equals("1")) {
            System.out.println("Application exited.");
            return;
        }

        // Main menu loop
        while (true) {
            System.out.println("\nPlease select one of the following menu items (1-6):");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
          

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    seriesApp.CaptureSeries();
                    break;
                case "2":
                    seriesApp.SearchSeries();
                    break;
                case "3":
                    seriesApp.UpdateSeries();
                    break;
                case "4":
                    seriesApp.DeleteSeries();
                    break;
                case "5":
                    seriesApp.SeriesReport();
                    break;
                case "6":
                    seriesApp.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid selection. Please choose a valid option.");
            }
        }
    }
}
