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
$ java -jar build/libs/BundlesCalculator-1.0-SNAPSHOT.jar
Error: Missing required argument(s): (<orderNum> <orderItem>)
Usage: BundleCalculator (<orderNum> <orderItem>)... [@<filename>...]
      [@<filename>...]   One or more argument files containing options.
      <orderNum>         The number of items
      <orderItem>        FormatCode: IMG, FLAC, VID
```

```console
$ java -jar build/libs/BundlesCalculator-1.0-SNAPSHOT.jar 13 VID
Apr 24, 2021 6:22:44 PM java.util.ArrayList forEach
INFO: 13 VID $2370.00
```

```console
$ java -jar build/libs/BundlesCalculator-1.0-SNAPSHOT.jar @/home/weixin/a.txt
Apr 24, 2021 6:24:09 PM java.util.ArrayList forEach
INFO: 10 IMG $800.00

Apr 24, 2021 6:24:09 PM java.util.ArrayList forEach
INFO: 15 FLAC $1957.50

Apr 24, 2021 6:24:09 PM java.util.ArrayList forEach
INFO: 13 VID $2370.00
```
