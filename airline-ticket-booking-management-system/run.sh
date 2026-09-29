#!/bin/sh
mkdir -p out
javac -d out src/airline/*.java || exit 1
java -cp out airline.Main
