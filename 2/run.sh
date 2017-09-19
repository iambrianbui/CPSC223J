#!/bin/bash

#Created by:  Brian Bui
#            iambrianbui@csu.fullerton.edu
#Created on:  14 September 2017
#Last edited:  14 Septemer 2017
#Course:         Cpsc 223J
#Semester:       2017 Fall
#Assignment:     #2
#Due date:


#File name:  run.sh
#Preconditions:
#   1.  All source files are in one directory
#   2.  This file, run.sh, is in that same directory
#   3.  The shell is currently active in that same directory
#How to execute: Enter "sh run.sh" without the quotes.

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java

echo Compile tictacAlg.java
javac tictacAlg.java

echo Compile tictacUI.java
javac tictacUI.java

echo Compile tictacMain.java
javac tictacMain.java

echo Execute the graphic display demonstration.
java tictacMain
s
echo End of execution.  Have a nice day.
