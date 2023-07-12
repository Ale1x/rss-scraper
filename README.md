# RssScraper Project

The RssScraper Project is a robust, multithreaded web scraping application designed to scrape and display content from multiple RSS feeds.

## Getting Started

### Prerequisites

This project is designed to run with Java SDK version 19.

### Running the Project

To run the RssScraper project, you will need a text file containing the URLs of the RSS feeds to scrape. Each URL should be on a new line.

The project is invoked via the command line, and takes the path to this file as an argument.

Example: `java -jar rssscraper.jar input.txt`

### Understanding the Code

The Java code for this project is located in the it.ale1x package.
Main.java is the entry point for the application. It reads a file containing the URLs of RSS feeds, creates a new RssScraper for each URL, and submits these tasks to a fixed thread pool. Each scraper then scrapes its assigned feed and prints the results.

### Contributing

Contributions to the RssScraper project are welcome! Please submit a Pull Request with your suggested changes, ensuring to follow our code style guide and include tests where applicable.
License
Please see the LICENSE file for details on the project's license.
