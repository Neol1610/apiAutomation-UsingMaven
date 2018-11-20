## How to setup and run API Automation

### Pre-requisites :-  
  1. Setup Java
  2. Setup Maven
  3. Download the Project from GIT

### Tools and Technologies Used :-
  1. **Java Version** : Java 6
  2. **Framework** : Maven + TestNG :  
     - TestNG (v 6.1.1) is a testing framework. It structures, groups, and launches tests.  
     - Maven (v 3.5.1) is a software project management and comprehension tool. It manages all dependencies and different flows for building a project.
  4. **API Automation using REST Assured** :  
  In REST Assured (v 2.9.0)  is a Java library for validation of REST web services.In REST Assured testing, we send a network request to our application, get a response back and compare it against a predetermined or expected result.
  5. **Reporting :**  
  Extent Reporting : Extent Report (v 2.41.0) is a HTML reporting library for Selenium WebDriver for Java which is to a great degree simple to use and makes excellent execution reports. We can use this tool within our TestNG automation framework. 

### Execution Steps :-
1. Extract the downloaded project
2. Open command Prompt or terminal
3. Go to the project location
4. Enter the below mentioned commands to compile and run the project :-  
	**Clean Project** : ``mvn clean``  
	**Compile Project** : ``mvn compile``  
	On Successful compilation of the project it will download all the dependencies like (TestNG, Extent Reporting and REST Assured)
	**Run the Project** : ``mvn test -Denv =MTurkQA``
	Here while running maven project we are using an extra command ``-Denv =MTurkQA`` . It is used to take input for environment specific data. Here we used QA for MTurk QA environment Data. In future if we wants to use UAT specific data then we can replace it with MTurk UAT. 
	

### Steps to read the API Automation Execution Result File :-
1. Go to the project directory
2. Click to open the HTML File
3. Once it will open, it looks like 
			
![Dashboard Report](Resources/Dashboard_Report.png)
             **Dashboard Report**

![Categorized Report](Resources/Categorized_Report.png)
             **Categorized Report**

![Individual Test Report](Resources/Individual_Test_Report.png)
			 **Individual Test Report**