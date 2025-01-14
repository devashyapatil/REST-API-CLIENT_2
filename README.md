# REST-API-CLIENT_2

**COMPANY**: CODETECH IT SOLUTIONS

**NAME**: Devashya Tulsidas Patil

**INTERN ID**: CT08JFE

**DOMAIN**: JAVA PROGRAMMING

**BATCH DURATIONN**: January 5th, 2025 to February 5th, 2025

**MENTOR NAME**: Neela Santhosh Kumar

# DESCRIPTION: 

**Objective**:
    The goal of this task is to develop a Java application that consumes a public REST API 
    (OpenWeather API) to fetch weather data for a given city and displays the data in a 
    structured format. The program handles HTTP requests and parses JSON responses, displaying 
    key weather details such as temperature, humidity, and wind speed.

**Steps Involved**:
    1. Setting Up the Project:
      -> We used IntelliJ IDEA to create a Java project.
      -> Maven was chosen as the build automation tool to manage dependencies, such as Gson for JSON parsing.
    2. Changes in pom.xml:
      -> In order to use Gson for JSON parsing, we modified the pom.xml file to include the necessary Maven dependency for Gson.
      -> The Gson library is used to parse the JSON data returned by the OpenWeather API, making it easy to extract relevant weather
         information such as temperature, humidity, and wind speed.
    Added Dependency in pom.xml:
          <dependencies>
            <dependency>
                <groupId>com.google.code.gson</groupId>
                <artifactId>gson</artifactId>
                <version>2.8.8</version>
            </dependency>
          </dependencies>
    3. OpenWeather API Setup:
        -> OpenWeather API is a public service that provides weather data in JSON format for cities around the world.
        -> We used the OpenWeather API to fetch real-time weather data. The API requires an API key for authentication. 
           The key used in this example is:
                       API Key: 454c7223b2922c0e4fd66cca134dcbc4
        -> We built the API URL to fetch weather data for a specific city:
                       https://api.openweathermap.org/data/2.5/weather?q={city_name}&appid={API_KEY}
           The {city_name} is a dynamic parameter, and {API_KEY} is your authentication key.
     4. Code Walkthrough:
        -> URL Construction: The URL for the API request is dynamically built by accepting user input for the city name.
        -> Making the HTTP GET Request: We use Java’s HttpURLConnection to send an HTTP GET request to the OpenWeather API.
           The connection is set up with the necessary headers to accept JSON responses.
        -> Reading the Response: After receiving the response, the program reads the data using a BufferedReader. 
           The response is stored in a StringBuilder for further processing.
        -> Parsing the JSON Response: We use Gson to parse the JSON response into a JsonObject,this allows us 
           to extract the specific data fields, such as the city name, temperature, humidity, and wind speed.
        -> Displaying the Data: The relevant data (city name, temperature, humidity, wind speed) is extracted
           and displayed in a structured format.
      5. Features Added:
        -> Dynamic City Input: The user is prompted to enter the city name, which is used to query the OpenWeather API.
        -> Input Validation: The application checks if the city name is empty before making the API request, ensuring that valid data is provided.
        -> Handling Different HTTP Response Codes: The program handles various HTTP status codes, including success (HTTP_OK) and failure (HTTP_NOT_FOUND).
        -> Modular Display Method: A separate method (displayWeatherData) was created to organize the code and handle the display of weather data in a structured format.
      6. Handling Errors:
        -> The program handles any potential exceptions (e.g., network issues, invalid city name) by catching them and printing an error message.
        
**How the Components Are Connected**:
     1. User Input: The user enters a city name.
     2. API Request: The application constructs the API URL with the user’s input and the API key.
     3. HTTP Request: An HTTP GET request is made to the OpenWeather API.
     4. API Response: The API responds with a JSON object containing weather data for the specified city.
     5. JSON Parsing: The response is parsed using the Gson library to extract the relevant data.
     6. Displaying Data: The extracted weather data (temperature, humidity, wind speed) is displayed to the user in a readable format.

This Java application demonstrates how to make HTTP requests to a public API, handle the response, parse JSON data, and display 
it in a structured format. The program is flexible and can easily be extended to support additional weather data fields or other APIs in the future.


# OUTPUT OF THE TASK: 




            

   
