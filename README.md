# System requirements:
- Windows 7+
- Java JDK 1.8
- Maven 3.6.3

Environment Variables Configured to work with Java and Maven

## How to run the tests

Once you clone this repo, first install dependencies, this just need to be run once:

```
mvn install
```

In order to execute the tests you just need to open a console and execute:

```
mvn test
```

Tests can also be run using IDEA with the contextual execution.

## Results

A ```.json``` report is beint generated and it's available in ```target/report.json```.