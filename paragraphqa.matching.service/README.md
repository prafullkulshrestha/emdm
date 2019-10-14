# Paragraph question and answer matching service

* The project matches the questions to the answers in a paragraph
* The project focuses on design to the interface principal instead of the concrete implementation.
* The project tries to achieve the open/close design principal by allowing the implementation of the different implementation
  of the readers and matchers.
* The projects focuses on creating the reusable component, encapsulates and loosely couples what might vary. 
* The project provides the an implementation of the paragraph and the question and answers reader, which reads their values from the 
  projects configuration file.
* The project provides an implementation of the matcher which uses the popular tf/idf principal to calculate the scores while matching the 
   query and the documents, also computes the cumulative scores wherever required.
* The project matcher filters the paragraph sentences to keep only those sentences which might have the answers.
* The project matcher creates the raw documents array for sentences, questions and answers.
* The project matcher calculates the match score of each questions with each sentences.
* The project matcher calculates the match score of each answer with each sentences.
* The project matcher calculates the match score for questions and answers using the max score out of what was computed above.
* The project matcher calculates the best question answer score and the corresponding indices for them in the original question 
  and answer array and returns the best matching answers to the questions.
  
## TF/IDF
 * TF stands for "Term Frequency". The number indicates the frequency of the word appearing in a document.
 * IDF stands for "Inverse Document Frequency". This means, how common or rare a word is in the entire document set. The closer it is to 0,      	the more common a word is. This metric can be calculated by taking the total number of documents, dividing it by the number of documents 	that contain a word, and calculating the logarithm. 

## Prerequisite
* Install JDK 1.8.
* Download STS to import and do further development on it
* Install Maven, I used version = 3.5.3
* I Built and run project on MAC or Unix based system 

## Import

* Checkout the project from the repository.
* In spring source tool IDE, click - File -> New -> "Java Project".
* Refer to the root directory of you project to import it as a new project
* Right click on the project in the IDE, go to "Configure" -> "Convert to maven project"
* Right click on the project in the IDE, go to "Maven" to update the project

## Testcases

* There are service class unit test cases only.

## Build

* Execute the command from the application root directory - 'mvn clean package' command to build the project.

## Start the application

* Execute the command from the following application root directory.
 mvn spring-boot:run and see the console to see the matched answers output

## Enhancements/Possible improvements

* There might be other ways also to perform the read and the match operations.
* Exception handling can be introduced to the project if required.
* More test cases could be added for testing the various other classes and methods to increase the code coverage.
* I've added only the happy path test cases and not focused on increasing the code coverage due to the time and health constraints. You can see my following project which proves that I can increase the coverage and implement the exception handling:
https://github.com/prafullkulshrestha/emdm/tree/master/emdm-api
