# Length Converter GUI Application 

## Overview
The Length Converter application is a Java-based GUI tool that converts a given distance in kilometers into one of the following units:

- Miles
- Yards
- Feet

## Description
The program uses the Chain of Responsibility (CoR) design pattern for the conversion logic and provides a user-friendly graphical interface built with Swing.

###Features
- Converts distances from kilometers to the selected target unit.
- Dropdown menu to select the desired target unit.
- User input validation to ensure correct conversions.
- Dynamic GUI layout for a professional look and usability.


## How to Run
To run the Program there are 2 ways

1)
- Compile all the java files using

javac -d com/lengthConverter/cor/*.java com/lengthConverter/cor/handler/*.java

- Now run the main java file

java -cp com/lengthConverter/cor/Main/LengthConverterMain.java

2)
- Run LengthConverterMain.java in eclipse or any other IDE, this java file present in package com.lengthConverter.cor.Main

## Author
- Tejas Vaity