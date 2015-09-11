# java-kata
Set of exercises to learn Java basics.

[Kata](https://en.wikipedia.org/wiki/Kata) is a Japanese martial arts concept to practice patterns of movement in repetitive manner. David Thomas has introduced Kata concept to programming world as [CodeKata](http://codekata.com/). By practicing the same pattern number of times, the learner can develop the ability to execute the techniques under different circumstances. 


The java-kata is designed to learn basic Java implementation techniques without using any 3rd party libraries. The only library dependency added to java-kata is JUnit which is used to execute the exercises. 

## How to use Kata
First step is to clone and build the project and you'll see bunch of test failures. The mission is to modify the code so that each test case passes. Along with passing each test, you'll get to learn how to use Java APIs.

#### Gradle build on Mac/Linux
```
$PROJECT_ROOT/gradlew build --info
```
#### Gradle build on Windows
```
%PROJECT_ROOT%/gradlew.bat build --info
```
Once you see the test failures, follow the hints in each test failure message and modify test code accordingly. 

e.g.
```
jp.itohiro.kata.Ex1FileKata > test1PathInstantiation FAILED
    java.lang.AssertionError: Hint: Create Path instance for "src/test/resources/ex1/file1" by using FileSystems
```

## Sample solutions
You can find sample solutions is solution branch, too. 
