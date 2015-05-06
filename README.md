# Example usage of the HashGenerator Library

**By:** Ryan Chapin [Contact Info](http://www.ryanchapin.com/contact.html)

The following is a simple program providing an example of how to use the [hashgenerator](https://github.com/rchapin/hash-generator) library.

## Building 

To build, simply run the following command in the hash-generator-example directory

```
# mvn clean package
```

This will build the project and create the jar in the target/ directory as expected.  This jar contains all of the dependencies necessary to run the program.

## Running

After building, execute the following command from the top level directory of the checked out repo:

```
java -cp ./target/hashgenerator-example-1.0.0-SNAPSHOT-jar-with-dependencies.jar com.ryanchapin.examples.HashGeneratorExample
```

