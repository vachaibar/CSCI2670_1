#! /bin/bash 

# Compile Java source files
javac -d bin src/*.java

# Run the compiled program with LinkedListDriver as the main class and input.txt as the input file
java -cp bin src.LinkedListDriver input.txt

# Clean up compiled files
rm -rf bin
