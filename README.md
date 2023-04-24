# Java Challenge

## Problem to be solved

Please create a variable data evaluation that is to be supplied with a data file and an instruction file and generate an output file. All files are in a json format. 
The structure of the files is not given by a schema and is only documented by the example files.

The input data is in a simple format: Each file contains a root object with one member `entries`. It defines a list of data points and can contain a variable number of members with child objects.
In our example, each data point is a city and has three members. One member is always present, this is called `name` and is used for filtering.

The operations are similar in structure. It contains an object with the member operations which defines a list of operation objects.
An operation always has five members:
- `name` - The name to be used for the output.
- `function` - The function to be evaluated, this can be `min`, `max`, `sum` or `average`.
- `field` – An array of member names to access the value for the operation.
- `filter` - A regular expression to be applied to the `name` member. Only those "entries" that match the regular expression should be included in the evaluation.

The output also consists of a list of objects which contain the operation name and the formatted calculated value. 
Floating point numbers are to be output with exactly two decimal places.

Attached you will find three files that perform such an evaluation.

An implementation on the Java VM is to be programmed; all standard libraries of the language you are using may be used, but no others.
As programming language you can use Java, Kotlin, Groovy or Scala.
An exception is a library to handle JSON files (e.g. [Jackson library](https://github.com/FasterXML/jackson-databind)).
If you use an external dependency use your favorite build tool (like Gradle, Maven, ...).
Possible other exceptions are unittesting libraries (like JUnit, TestNG, etc.).

## Files provided

The following files are supplied to solve the problem:

- data.json Example of input data.
- operations.json Example of operations to be calculated.
- output.json The results for the sample data provided.
- JsonCalculator class as entry point

## Notes on the delivery

Please check the result back into this repository on the branch solution. Once you have uploaded your final solution, please give a short note to jobs@itdesign.de.

## Run Command 

gradle run --args='data.json operations.json outputs.json'