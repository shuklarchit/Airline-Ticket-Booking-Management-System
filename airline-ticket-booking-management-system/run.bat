@echo off
if not exist out mkdir out
javac -d out src\airline\*.java
if errorlevel 1 (
    echo Compilation failed.
    exit /b 1
)
java -cp out airline.Main
