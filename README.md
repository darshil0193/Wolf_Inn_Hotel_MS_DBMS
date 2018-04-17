# Wolf_Inn_Hotel_MS_DBMS

## Team H - CSC 540 Demo

Team Structure
------------------------
Darshil Patel (dpatel14) - Prime Application Programmer, Database Designer, Test Plan Engineer

Pranshu Sinha (psinha) - Prime Application Programmer, Database Designer, API Designer

Sameer Poudwal (spoudwa) - Software Engineer, API Designer

Srujan Barai (sjbarai) - Test PLan Engineer, Software Designer

How to Compile / Run
------------------------
```
add mysql
add jdk
```

To populate the database, navigate to the folder from the terminal and type,
```
javac Wolfinn.java
java Wolfinn
```

To run the command line interface, navigate to the folder from the terminal and type,
```
javac TasksAndOperations.java
java TasksAndOperations
```

To run the transactions file type,
```
javac Transactions.java
java Transactions
```

General Structure
------------------------
The Wolfinn.java file is crud file used to populate the database.

TasksAndOperations.java is the file used for providing a CLI with the application.
It has all the necessary APIs used to interact with the system.

Lastly, the Transactions.java file creates transaction for two operations, viz. Check-in and Check-out.
The Check-in and Check-out transactions commit only if all the inputs are valid and roll back otherwise.


Transaction Support
------------------------
Transaction support has been added for two processes, namely check-in and check-out.
These two processes require queries to be executed on multiple tables and these changes commit if all the inputs are valid.
Else, changes done to each of the tables are rolled back.
