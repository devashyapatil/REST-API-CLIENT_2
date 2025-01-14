package com.task2.restapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

/**
 * A Java application that consumes a public REST API (OpenWeather API)
 * to fetch weather data for a specified city and displays the data in a structured format.
 */
public class RestApiClient {

    // API URL with a placeholder for city name and the API key
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private static final String API_KEY = "454c7223b2922c0e4fd66cca134dcbc4"; // Your API key for OpenWeather

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a city name
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        // Validate user input for empty city name
        if (city.isEmpty()) {
            System.out.println("City name cannot be empty.");
            return;  // Exit if the city name is empty
        }

        // Construct the full API URL by inserting the city and API key
        String apiUrl = String.format(API_URL, city, API_KEY);

        try {
            // Step 1: Establish an HTTP connection to the API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json"); // Set header to accept JSON response

            // Step 2: Get the response code and check if the request was successful
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // HTTP 200 OK
                // Step 3: Read the response data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);  // Append each line of the response
                }
                reader.close();  // Close the reader after use

                // Step 4: Parse the JSON response using Gson
                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

                // Step 5: Extract specific data from the JSON response
                String cityName = jsonResponse.get("name").getAsString(); // City name
                JsonObject main = jsonResponse.getAsJsonObject("main");
                double temperature = main.get("temp").getAsDouble() - 273.15; // Convert temperature from Kelvin to Celsius
                int humidity = main.get("humidity").getAsInt(); // Humidity percentage
                JsonObject wind = jsonResponse.getAsJsonObject("wind");
                double windSpeed = wind.get("speed").getAsDouble(); // Wind speed

                // Step 6: Display the weather information in a structured format
                displayWeatherData(cityName, temperature, humidity, windSpeed);
            } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) { // HTTP 404 Not Found
                System.out.println("City not found.");
            } else {
                System.out.println("Failed to fetch data. HTTP response code: " + responseCode);
            }

            connection.disconnect(); // Close the connection after use
        } catch (Exception e) {
            // Step 7: Handle any exceptions that occur during the API request
            System.out.println("An error occurred while fetching the weather data.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    /**
     * Displays the weather information in a structured format.
     * @param cityName The name of the city
     * @param temperature The temperature in Celsius
     * @param humidity The humidity percentage
     * @param windSpeed The wind speed in meters per second
     */
    private static void displayWeatherData(String cityName, double temperature, int humidity, double windSpeed) {
        System.out.println("\nWeather Information for " + cityName + ":");
        System.out.println("Temperature: " + String.format("%.2f", temperature) + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Wind Speed: " + windSpeed + " m/s");
    }
}

