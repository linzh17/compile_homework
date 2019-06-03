#!/bin/bash
java -jar java-cup-11b.jar process.cup 
javac parser.java
javac sym.java
javac start.java
java start test.txt
