# Assignment Selector

This app assign exercises (given as numbers) to people who should prepare those tasks.

For example:
* given exercises: from 18 to 28
* given people: Safał, Gakub, Dikołaj

Possible output:
* Dikołaj = 18, 19, 20, 21
* Gakub = 22, 23, 24, 25
* Safał = 26, 27, 28

## Preliminaries

At least Java Development Kit and Java Runtime Environment in 1.8 version.

```
sudo apt-get install openjdk-8-jdk
```

## Build

For building project mvn-wrapper is used.

From main project directory run:
* for Unix-like systems:
```
./mvnw package
```

* for windows systems:
```
mvnw.cmd package
```

## Run

To run application use command:

```bash
$ java -jar assignment-selector.jar $PARAMETERS$
```

Possible `$PARAMETERS$` are defined in program help
