# Currency Converter

## Overview
This Currency Converter allows users to input an amount of currency and convert it into another currency. The application supports theme switching between light and dark modes and provides a user-friendly interface for easy conversions. Unlike other converters that use buttons for selection, this one requires the user to type the currency names in a "from-to" format (e.g., "USD to BRL").

## Technologies Used
- **JavaFX**: Used to create the graphical user interface for the application, providing features like buttons, text fields, and layout management.
- **Maven**: Used for project management, handling dependencies, and building the project.
- **Java**: The core programming language for implementing the business logic and handling UI events.

## Features
- **Currency Conversion**: Users can input the currency amount and select the source and target currencies.
- **Dynamic Result Display**: The conversion result is dynamically displayed as the user inputs data.
- **Light/Dark Theme Toggle**: Users can switch between light and dark themes for a personalized experience.
- **Clear Button**: A button to clear all input fields and results.

## API Use
The API used was the [Currency Converter API](https://freecurrencyapi.com/), which provides real-time exchange rates for the conversion.

## Future Improvements
- **More Currencies**: Extend the supported currencies by integrating an API that provides real-time exchange rates.
- **Responsive Design**: Although the layout works well on standard screen sizes, more optimization can be done to ensure the UI adapts perfectly on mobile screens.

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK)**: [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html). You can verify if it's installed by running `java -version` in your terminal.

2. **Apache Maven**: [Install Maven](https://maven.apache.org/install.html). Verify installation with `mvn -v`.

## Setting Up and Running the Project

1. Clone the repository to your local machine using the following command:
   ```
   git clone https://github.com/pedrocappelini/CurrencyConverter.git
   ```

2. Navigate to the project directory:
   ```
   cd CurrencyConverter
   ```

3. Build the project and install dependencies:
   ```
   mvn clean install
   ```

4. Run the application with:
   ```
   mvn javafx:run
   ```

This will launch the Currency Converter application.
