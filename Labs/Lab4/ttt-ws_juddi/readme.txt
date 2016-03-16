This is a distributed game of Tic Tac Toe implemented using Java Web Services.
The server is published to a jUDDI registry and
the client uses the name server to find the actual server location.

The server is a Web Service.
It stores the game state and provides operations for modifying it.


Instructions using Maven:
------------------------

To run the jUDDI server (required):
  Check if the environment variable CATALINA_HOME is properly set
  On Windows:
    startup
  On Linux:
    startup.sh
  Wait for the following log message: "INFO: Server startup in ... ms"
  Visit http://localhost:9090/juddiv3/ to confirm that the name server is running.

To compile:
  mvn compile

To run using exec plugin:
  mvn exec:java

To generate launch scripts for Windows and Linux:
  (appassembler:assemble is attached to install phase)
  mvn install

To run using appassembler plugin:
  On Windows:
    target\appassembler\bin\ttt-ws http://localhost:9090 TTT http://localhost:8080/ttt-ws/endpoint
  On Linux:
    ./target/appassembler/bin/ttt-ws http://localhost:9090 TTT http://localhost:8080/ttt-ws/endpoint


When starting, the web service registers itself on the UDDI server.
When stopping, the registration is deleted.

When running, the web service awaits connections from clients.
You can check if the service is running using your web browser 
to see the generated WSDL file:

    http://localhost:8080/ttt-ws/endpoint?WSDL

This address is defined when the publish() method is called.

To call the service you will need a web service client,
including code generated from the WSDL.


To configure the project in Eclipse:
-----------------------------------

If Eclipse files (.project, .classpath) exist:
    'File', 'Import...', 'General'-'Existing Projects into Workspace'
    'Select root directory' and 'Browse' to the project base folder.
    Check if everything is OK and 'Finish'.

If Eclipse files do not exist:
    'File', 'Import...', 'Maven'-'Existing Maven Projects'.
    'Browse' to the project base folder.
    Check that the desired POM is selected and 'Finish'.

To run:
    Select the main class and click 'Run' (the green play button).
    Specify arguments using 'Run Configurations'


--
Revision date: 2016-02-10
leic-sod@disciplinas.tecnico.ulisboa.pt