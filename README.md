# Code Test -- Bundles Calculate
## Tech Stack
* Lombok
* Picocli

### This is the Picocli based Command line interface. It supports the below functions:

* Calculate the total amount by input single line args in shell
* Calculate the total amount by input multiple lines args by file

## How to run this application

* Navigate the root folder /CodeTest--BundlesCalculator
* Run the command to build the whole project: **gradle clean build**
* Run the command to start the application: **java -jar build/libs/BundlesCalculator-1.0-SNAPSHOT.jar `<bundlesNum> <formatCode>`**
* Or the command **java -jar build/libs/BundlesCalculator-1.0-SNAPSHOT.jar @filePath**
```console
Usage: BundleCalculator (<bundlesNum> <formatCode>)... [@<filename>...]
      [@<filename>...]   One or more argument files containing options.
      <bundlesNum>       The number of items
      <formatCode>       FormatCode: IMG, FLAC, VID

```

