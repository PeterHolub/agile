# AgileEngine Task
implementation of AgileEngine test task
## Prerequisites
* **JDK >= 1.8.0_131**;
* **Apache Maven >= 3.5.2**
## Project structure 
* com.peterholub.fileloader - package with interface and implementation for loading html files 
* com.peterholub.matcher - package with interface and  class implementation to find matched element by attributes
* com.peterholub.xpatchbuilder - package with interface and class implementation for creating xpath
* com.peterholub.SmartXMLAnalyzer - class with main method with option to parse html pages, find matched element by iteration and print result

## Run 
Run script for execution:
```
java -jar agileEngineTask-1.0-jar-with-dependencies.jar <input_origin_file_path> <input_other_sample_file_path> <target_element_id>

```
example:
```
java -jar agileEngineTask-1.0-jar-with-dependencies.jar C:\agile\src\main\resources\sample-0-origin.html C:\agile\src\main\resources\sample-1-evil-gemini.html make-everything-ok-button
```