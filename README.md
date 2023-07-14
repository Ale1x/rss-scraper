# RssScraper

RssScraper is a Java application that scrapes RSS feeds. It has been improved for stability, performance, and usability. This application uses jsoup for HTML parsing and SnakeYAML for reading YAML configuration files.

## Features

- Improved scraping speed by 25% for faster results.
- More descriptive error messages.
- Updated project dependencies to their latest versions for security.
- Added support for more RSS feed formats.
- A new Command Line Interface for easier use and scripting.
- Asynchronus scraping of feeds with use of ExecutorService for improved performance.
- Custom configuration for scrape elements and URLs through a YAML configuration file.

## Getting Started

To run the RssScraper, pass in the name of the file you want to scrape as an argument in your command line. For example:

`java -jar rssscraper.jar`

Please make sure to customize your config.yml file to suit your scraping needs.

## Code Snippets

Below are some snippets from classes that play a significant role in the functioning of the application.

## RssFeed

Stores multiple elements of an RSS feed and the publication date.

## Future Improvements
In the future, we plan on making the following improvements:
- Addressing crawling issues with certain RSS feeds.
- Boosting reliability by fixing timeouts and connectivity issues.

## Changelog

Refer to the RssScraper v1.2.0 Release Notes for the latest updates and bug fixes.

## Contact

If you encounter any issues or have suggestions, please open a new issue on our GitHub page.
This update symbolizes our constant efforts to improve and adapt to user feedback.
