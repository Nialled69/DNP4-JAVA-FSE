@echo off
REM Script to run Maven from any subdirectory
REM Usage: mvn-run.bat <maven-command>
REM Example: mvn-run.bat compile exec:java -Dexec.mainClass="com.library.LibraryApplication"

REM Find the root directory (where mvnw is located)
set SCRIPT_DIR=%~dp0
set ROOT_DIR=%SCRIPT_DIR%

REM Check if we're in the root directory
if exist "%ROOT_DIR%mvnw" (
    echo Using Maven wrapper from: %ROOT_DIR%
    "%ROOT_DIR%mvnw" %*
) else (
    echo Error: Maven wrapper not found in %ROOT_DIR%
    echo Make sure you're running this from the DNP4-JAVA-FSE directory
    exit /b 1
) 