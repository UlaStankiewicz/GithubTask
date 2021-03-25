Requirements:

- Installed JDK 15.
- Installed IDE for Java. IntelliJ IDEA recommended.
- installed and updated Google Chrome.

Steps:

1) Download projcet from repository and open projcet with IDE.
2) Make sure that all dependencies from file pom.xml are properly downloaded.
3) Depending on the operating system on which the tests will be run, select the appropriate driver. For this purpose, 
open the properties.properties file in src/test/resource/ and set the "driver" property for one of the following:
 
		CHROME_WINDOWS - this setup will run tests on Windows. This is a default setup.
		CHROME_IOS - this setup will run tests on IOS system. 
    
4) There are two ways of running tests:

    a) Run the RunTest class in src/test/java/ . This will run all the features and scenarios in project
    b) go to src/test/resource/features directory. There you will find .feature files wich can be run independently as well as scenarios included in files.
