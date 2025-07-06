#!/bin/bash

# Script to run Maven from any subdirectory
# Usage: ./mvn-run.sh <maven-command>
# Example: ./mvn-run.sh compile exec:java -Dexec.mainClass="com.library.LibraryApplication"

# Find the root directory (where mvnw is located)
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$SCRIPT_DIR"

# Check if we're in the root directory
if [ -f "$ROOT_DIR/mvnw" ]; then
    echo "Using Maven wrapper from: $ROOT_DIR"
    "$ROOT_DIR/mvnw" "$@"
else
    echo "Error: Maven wrapper not found in $ROOT_DIR"
    echo "Make sure you're running this from the DNP4-JAVA-FSE directory"
    exit 1
fi 