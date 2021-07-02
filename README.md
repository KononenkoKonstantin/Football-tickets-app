# Football tickets app

This application allows management of football tickets sales. This application is according to the requirements of SOLID principles for easy reading, testing, and extension. 
It's the RESTfull application with authentication and authorization possibilities. 

## Architecture
I used n-tired architecture in this application:
- dao
- service
- model
- controller
- security
- etc

## Technologies
- Spring - Core, MVC, Web, Security
- Hibernate
- MySQL
- Tomcat
- Logger

## How to use locally
- Download project.
- Open it in your IDE.
- Configure file src/main/resources/db.properties (db.driver, db.url, db.user, db.password)".
- Install and configure Tomcat (set "/" in Deployment - taxi-service:war exploded - Application context).
- Configure path to log file in resources/log4j2.xml.
- Run Tomcat.
- Type "/login" in your browser.
- Use following default credential:
  
  admin: admin@gmail.com 1234
  
  user:  user@gmail.com 1111.
  
  You can change these credentials in util/DataInitializer.

## Permissions
### Unauthorized user can:
 - register
### Admin can: 
- search information about users;
- get, add information of stadiums, games, available game sessions;
- get, put, delete information of game session;
### Registered user can:
- get information about stadiums, games, available game sessions;
- get information about orders, games, available game sessions;
- complete his orders, add game sessions.



