This is Java RMI implementation of the Tic Tac Toe game client.


Instructions using Maven:
------------------------

To compile and copy the properties file to the output directory:
  mvn compile

To generate launch scripts for Windows and Linux:
  (appassembler:assemble is attached to install phase)
  mvn install

To run:
  Using Maven exec plugin:
    mvn exec:java
  Using Maven appassembler plugin:
    On Windows:
      target\appassembler\bin\ttt-rmi-client
    On Linux:
      ./target/appassembler/bin/ttt-rmi-client


To configure the Maven project in Eclipse:
-----------------------------------------

If Maven pom.xml exist:
    'File', 'Import...', 'Maven'-'Existing Maven Projects'
    'Select root directory' and 'Browse' to the project base folder.
	Check that the desired POM is selected and 'Finish'.

If Maven pom.xml do not exist:
    'File', 'New...', 'Project...', 'Maven Projects'.
	Check 'Create a simple project (skip architype selection)'.
	Uncheck  'Use default Workspace location' and 'Browse' to the project base folder.
	Fill the fields in 'New Maven Project'.
	the Check if everything is OK and 'Finish'.

To run:
    Select the main class and click 'Run' (the green play button).
    Specify arguments using 'Run Configurations'


--
Revision date: 2015-04-23
leic-sod@disciplinas.tecnico.ulisboa.pt
