# Currency Converter

## Overview

This Java application provides a currency conversion tool using real-time exchange rates from the ExchangeRate-API. It features a user-friendly graphical interface with a custom background image. Users can select the source and target currencies, enter an amount, and view the converted result.

## Files Included

1. **`CurrencyConverter.java`**: The main Java source file containing the logic for currency conversion and the graphical user interface.
2. **`background.png`**: The background image used in the application's GUI.
3. **`json-20240303.jar`**: JSON library dependency required for parsing JSON responses from the API.

## Prerequisites

- Java Development Kit (JDK) version 8 or higher
- JSON library (`json-20240303.jar`)

## Setup Instructions

1. **Add JSON Dependency:**
   - Place the `json-20240303.jar` file in your project's library directory or include it in your classpath.
   - If using an IDE like IntelliJ IDEA or Eclipse, add the JAR file to your project's build path.

2. **Compile the Java Source File:**
   Open a terminal or command prompt and navigate to the directory containing `CurrencyConverter.java`. Compile the file using the following command:
   ```bash
   javac -cp .;path/to/json-20240303.jar CurrencyConverter.java
   ```
   Replace `path/to/json-20240303.jar` with the actual path to the JSON JAR file.

3. **Run the Application:**
   Execute the compiled class file with the following command:
   ```bash
   java -cp .;path/to/json-20240303.jar CurrencyConverter
   ```

4. **Using the Application:**
   - The GUI will open with options to select the source and target currencies.
   - Enter the amount to be converted.
   - The converted result will be displayed on the interface.

## Screenshots

![Screenshot 2024-07-26 220247](https://github.com/user-attachments/assets/31d42c38-4c08-4cfb-b8a5-b0e6ad4d2e76)
![Screenshot 2024-07-26 220318](https://github.com/user-attachments/assets/75decfb8-c19e-4f53-b0ef-322ea5220899)
![Screenshot 2024-07-26 220336](https://github.com/user-attachments/assets/6255222c-8669-4f6a-91d7-e55cf11d32e9)
![Screenshot 2024-07-26 220223](https://github.com/user-attachments/assets/0dcccbac-58d1-4097-b540-3d57ee211c34)

## Notes

- Ensure the `json.jar` file is included in the classpath to avoid runtime errors.
- An active internet connection is required to fetch real-time exchange rates from the ExchangeRate-API.
- **Important**: If the ExchangeRate-API service is unavailable or fails in the future, you can update the `API_KEY` and `API_URL` constants in `CurrencyConverter.java` to use your own API key from a different currency conversion service. Make sure to adjust the API request and response handling code according to the new API's specifications.

## Credits

The JSON processing library used in this project is from [stleary's GitHub repository](https://github.com/stleary/JSON-java). 

We acknowledge and give credit to the author of the library. This project uses the JAR file provided by stleary, and you can find more information about it on their GitHub page.

**Note:** This usage complies with the library's license and terms. Please refer to the repository for detailed licensing information.



## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
